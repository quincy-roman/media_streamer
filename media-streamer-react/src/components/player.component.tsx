// import video from "assets/test.mp4"
import React from "react";
import { useParams } from "react-router-dom";

const Player = () => {
    const {title, url} = useParams()
    console.log(title, url)

    return (
        <div className="player">
            <h1>{title}</h1>
            <video controls>
                <source src='/assets/test.mp4' type="video/mp4"/>
            </video>
        </div>
    )
}

export default Player;