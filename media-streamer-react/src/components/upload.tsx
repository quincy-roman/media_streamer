import axios from "axios";
import React, { FormEventHandler, useState } from "react";

const Upload = (props: FileUpload) => {

    const [state, setState] = useState(props)

    const onChange = (e: any) => {
        setState({ file: e.target.files[0] })
    }

    const handleSubmit = (e: any) => {
        e.preventDefault()

        if (state.file)
            fileSubmit(state.file).then(res => console.log(res))
        else
            console.log('No file selected')
    }

    const fileSubmit = (file: File) => {
        const formData = new FormData();
        formData.append('title', file.name)
        formData.append('video', file)

        const config = {
            headers: {
                'content-type': 'multipart/form-data'
            }
        }

        return axios.post(`http://localhost:8080/video`, formData, config)
    }

    return (
        <form onSubmit={handleSubmit}>
            <h1>File Upload</h1>
            <input type="file" onChange={onChange} />
            <button type="submit">Upload</button>
        </form>
    )
}
export default Upload;

export type FileUpload = {
    file?: File
}