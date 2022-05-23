package io.video.videos.service;

import java.io.IOException;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.video.videos.model.Photo;
import io.video.videos.repository.PhotoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PhotoService {

    private PhotoRepository repo;

    public String addPhoto(String title, MultipartFile file) throws IOException {
        Photo photo = new Photo(title);
        photo.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        return repo.insert(photo).getId();
    }

    public Photo getPhoto(String id) {
        return repo.findById(id).get();
    }
}