// import video from "assets/test.mp4"
import React from "react";
import { useParams } from "react-router-dom";

const Player = () => {
    const {title, id} = useParams()
    console.log(title, id)

    return (
        <div className="player">
            <h1>{title}</h1>
            <video controls>
                <source src={`http://localhost:8080/video/${id}`} type="video/mp4"/>
            </video>
        </div>
    )
}

export default Player;