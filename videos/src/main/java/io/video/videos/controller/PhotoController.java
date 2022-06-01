package io.video.videos.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.video.videos.model.Photo;
import io.video.videos.service.PhotoService;
import lombok.AllArgsConstructor;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/photos")
public class PhotoController {

    private PhotoService service;

    @GetMapping("/{id}")
    public ResponseEntity<Photo> getPhoto(String id) {
        Photo photo = service.getPhoto(id);
        // photo.getImage().getData();
        return ResponseEntity.ok(photo);
    }

    @PostMapping
    public ResponseEntity<String> addPhoto(String title, MultipartFile image) throws IOException {
        return ResponseEntity.ok(service.addPhoto(title, image));
    }

}