package io.video.videos.model;

import java.io.InputStream;

import lombok.Data;
import lombok.Value;

@Data
public class Video {
    
    private String title;
    private InputStream stream;

    @Value
    public static class VideoInfo {
        protected String id;
        protected String filename;
    }

}