package com.example.demo.services.Impl;

import com.example.demo.services.CensorService;
import com.mongodb.client.result.DeleteResult;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class CensorServiceImpl implements CensorService {

    private final MongoTemplate mongoTemplate;

    @Override
    public Document findCensorById(String id) {
        //build query
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(new ObjectId(id)));

        return mongoTemplate.findOne(query, Document.class, "employees");
    }

    @Override
    public List<Document> findAllCensor(int pageNo, int pageSize) {
        //build query
        Query query = new Query();
        query.skip((long) (pageNo - 1) * pageSize);
        query.limit(5);

        return mongoTemplate.find(query, Document.class, "employees");
    }
    @Override
    public Document addNewPost(Map<String, Object> censorInput) {
        //build document
        Document doc = new Document("target", censorInput.get("target"))
                .append("owner", censorInput.get("owner"))
                .append("category", censorInput.get("category"))
                .append("type", censorInput.get("type"))
                .append("lang", censorInput.get("lang"))
                .append("content", censorInput.get("content"))
                .append("level", censorInput.get("level"))
                .append("when", censorInput.get("when"));

        return mongoTemplate.insert(doc, "employees");
    }

    @Override
    public Document editMediasOfPost(String id, List<Map<String, Object>> medias) {
        //build query
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(new ObjectId(id)));

        //build update
        Update update = new Update();
        update.set("content.medias", medias);

        return mongoTemplate.findAndModify(query, update, FindAndModifyOptions.options().returnNew(true),
                Document.class, "employees");
    }

    @Override
    public DeleteResult deleteCensorById(String id) {
        //build query
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(new ObjectId(id)));

        return mongoTemplate.remove(query, "employees");
    }
}
