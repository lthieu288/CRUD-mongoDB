package com.example.demo.services;

import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import java.util.List;
import java.util.Map;

public interface CensorService {
    //CRUD censor of Post
    Document addNewPost(Map<String, Object> censorInput);
    Document editMediasOfPost(String id, List<Map<String, Object>> censorInput);
    Document findCensorById(String id);
    List<Document> findAllCensor(int pageNo, int pageSize);
    DeleteResult deleteCensorById(String id);
}
