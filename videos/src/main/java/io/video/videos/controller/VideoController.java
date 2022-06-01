package io.video.videos.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.video.videos.service.VideoService;
import lombok.AllArgsConstructor;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/video")
public class VideoController {

    private VideoService service;

    @GetMapping("/{id}")
    public ResponseEntity<Resource> getStream(@PathVariable String id) throws IllegalStateException, IOException {
        return ResponseEntity.ok(new InputStreamResource(service.getVideo(id).getStream()));
    }

    @PostMapping
    public ResponseEntity<String> addVideo(String title, MultipartFile video) throws IOException {
        return ResponseEntity.ok(service.addVideo(title, video));
    }

    @GetMapping("/all")
    public ResponseEntity<List<String>> getAllVideoNames() {
        return ResponseEntity.ok(service.getAllVideoNames());
    }
}