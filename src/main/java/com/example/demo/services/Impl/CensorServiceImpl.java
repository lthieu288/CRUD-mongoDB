package com.example.demo.services.Impl;

import com.example.demo.data.models.CensorOfComment;
import com.example.demo.data.models.CensorOfMedia;
import com.example.demo.data.models.CensorOfPost;
import com.example.demo.data.models.subMovie.Medias;
import com.example.demo.services.CensorService;
import com.mongodb.client.result.DeleteResult;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CensorServiceImpl implements CensorService {

    private final ModelMapper modelMapper;
    private final MongoTemplate mongoTemplate;

    @Override
    public CensorOfPost addNewPost(CensorOfPost censorOfPostInput) {
        CensorOfPost censor = modelMapper.map(censorOfPostInput, CensorOfPost.class);

        return mongoTemplate.insert(censor);
    }

    @Override
    public CensorOfPost editMediasOfPost(String id, List<Medias> medias) {
        //build query
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(new ObjectId(id)));

        //build update
        Update update = new Update();
        update.set("content.medias", medias);

        return mongoTemplate.findAndModify(query, update, FindAndModifyOptions.options().returnNew(true), CensorOfPost.class);
    }

    @Override
    public CensorOfPost findPostById(String id) {
        //build query
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(new ObjectId(id)));

        return mongoTemplate.findOne(query, CensorOfPost.class);
    }

    @Override
    public List<CensorOfPost> findAllCensorOfPost(int pageNo, int pageSize) {
        //build query
        Query query = new Query();
        query.skip((pageNo - 1) * pageSize);
        query.limit(5);

        return mongoTemplate.find(query, CensorOfPost.class);
    }

    @Override
    public DeleteResult deleteCensorOfPostById(String id) {
        //build query
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(new ObjectId(id)));

        return mongoTemplate.remove(query, CensorOfPost.class);
    }


    @Override
    public CensorOfComment addNewComment(CensorOfComment censorOfComment) {
        return null;
    }

    @Override
    public CensorOfComment editComment(String id, CensorOfComment censorOfComment) {
        return null;
    }

    @Override
    public CensorOfComment findCommentById(String id) {
        return null;
    }

    @Override
    public CensorOfMedia addNewMedia(CensorOfMedia censorOfMedia) {
        return null;
    }

    @Override
    public CensorOfMedia editMedia(String id, CensorOfMedia censorOfMedia) {
        return null;
    }

    @Override
    public CensorOfMedia findMediaById(String id) {
        return null;
    }
}
