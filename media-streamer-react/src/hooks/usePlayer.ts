import { useState, useEffect, ChangeEvent, MutableRefObject } from "react"

const useVideoPlayer = (videoElement: MutableRefObject<HTMLVideoElement>) => {
    const [playerState, setPlayerState] = useState({
        isPlaying: true,
        progress: 0,
        speed: 1,
        isMuted: false
    })

    const togglePlay = () => {
        setPlayerState({ ...playerState, isPlaying: !playerState.isPlaying })
    }

    useEffect(() => {
        playerState.isPlaying ? videoElement.current.play() : videoElement.current.pause()
    }, [playerState.isPlaying, videoElement])

    const handleOnTimeUpdate = () => {
        const progress = (videoElement.current.currentTime / videoElement.current.duration) * 100
        setPlayerState({ ...playerState, progress })
    }

    const handleVideoProgress = (event: ChangeEvent<HTMLInputElement>) => {
        const manualChange = Number(event.target.value)
        videoElement.current.currentTime = (videoElement.current.duration * 100) / manualChange
        setPlayerState({ ...playerState, progress: manualChange})
    }

    const handleVideoSpeed = (event: ChangeEvent<HTMLSelectElement>) => {
        const speed = Number(event.target.value)
        videoElement.current.playbackRate = speed
        setPlayerState({ ...playerState, speed})
    }

    const toggleMute = () => {
        setPlayerState({ ...playerState, isMuted: !playerState.isMuted })
    }
    useEffect(() => {
        videoElement.current.muted = playerState.isMuted
    }, [playerState.isMuted, videoElement])

    const toggleFullscreen = () => {
        if(videoElement.current)
            videoElement.current.requestFullscreen()
    }

    return {
        playerState, 
        togglePlay, 
        handleVideoProgress, 
        handleOnTimeUpdate, 
        handleVideoSpeed, 
        toggleMute, 
        toggleFullscreen
    }
}

export default useVideoPlayer