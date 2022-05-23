package io.video.videos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.video.videos.model.Photo;

@Repository
public interface PhotoRepository extends MongoRepository<Photo, String> { }