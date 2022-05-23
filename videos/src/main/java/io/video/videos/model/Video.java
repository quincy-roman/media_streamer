package io.video.videos.model;

import java.io.InputStream;

import lombok.Data;

@Data
public class Video {
    
    private String title;
    private InputStream stream;

}