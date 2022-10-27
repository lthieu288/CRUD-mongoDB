package com.example.demo.services.Impl;

import com.example.demo.data.models.ObjectDto;
import com.example.demo.data.models.subMovie.Medias;
import com.example.demo.services.ObjectService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ObjectServiceImpl implements ObjectService {

    private final MongoTemplate mongoTemplate;

    @Override
    public ObjectDto pushNewField(String id, String fieldName, String fieldValue, String valueCondition) {

        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(new ObjectId(id)));

        Update update = new Update();
        update.set("content.medias.$[cond]." + fieldName, fieldValue);
        update.filterArray("cond.id", valueCondition);
        FindAndModifyOptions findAndModifyOptions = new FindAndModifyOptions().returnNew(true);

        ObjectDto objectDto = mongoTemplate.findAndModify(query, update, findAndModifyOptions, ObjectDto.class);

        return objectDto;
    }

    @Override
    public ObjectDto deleteField(String id, String fieldName, String valueCondition) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(new ObjectId(id)));

        Update update = new Update();
        update.unset("content.medias.$[cond]." + fieldName);
        update.filterArray("cond.id", valueCondition);
        FindAndModifyOptions findAndModifyOptions = new FindAndModifyOptions().returnNew(true);

        ObjectDto objectDto = mongoTemplate.findAndModify(query, update, findAndModifyOptions, ObjectDto.class);

        return objectDto;
    }

    @Override
    public ObjectDto pushToMedias(String id, Medias medias) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(new ObjectId(id)));

        Update update = new Update();
        update.push("content.medias", medias);
        FindAndModifyOptions findAndModifyOptions = new FindAndModifyOptions().returnNew(true);

        ObjectDto objectDto = mongoTemplate.findAndModify(query, update, findAndModifyOptions, ObjectDto.class);

        return objectDto;
    }
}
