package io.video.videos.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.video.videos.model.Photo;
import io.video.videos.service.PhotoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/photos")
public class PhotoController {

    private PhotoService service;

    @GetMapping
    public ResponseEntity<List<Photo>> getAllPhotos() {
        return ResponseEntity.ok(service.getAllPhotos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Photo> getPhoto(@PathVariable String id) {
        log.info("Id: {}", id);
        Photo photo = service.getPhoto(id);
        // photo.getImage().getData();
        return ResponseEntity.ok(photo);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> addPhoto(String title, MultipartFile image) throws IOException {
        return ResponseEntity.ok(Collections.singletonMap("id", service.addPhoto(title, image)));
    }

}