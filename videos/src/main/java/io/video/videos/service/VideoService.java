package io.video.videos.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.video.videos.model.Video;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class VideoService {
    
    private GridFsTemplate template;
    private GridFsOperations operations;

    public String addVideo(String title, MultipartFile file) throws IOException {
        DBObject metaData = new BasicDBObject();
        metaData.put("type", "video");
        metaData.put("title", title);

        return template.store(file.getInputStream(), file.getName(), file.getContentType()).toString();
    }

    public Video getVideo(String id) throws IllegalStateException, IOException {
        GridFSFile file = template.findOne(new Query(Criteria.where("_id").is(id)));
        
        Video video = new Video();
        video.setTitle(file.getMetadata().get("title").toString());
        video.setStream(operations.getResource(file).getInputStream());

        return video;
    }

    public List<String> getAllVideoNames() {
        Query query = new Query();
        query.fields().include("name");
        template.find(query).forEach(doc -> log.info("{}", doc));
        return new ArrayList<>();
    }
}