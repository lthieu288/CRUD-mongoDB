package com.example.demo.controllers;

import com.example.demo.exception.BadRequestException;
import com.example.demo.services.CensorService;
import com.mongodb.client.result.DeleteResult;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/censor")
@RequiredArgsConstructor
public class CensorController {

    private final CensorService censorService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getCensorOfPostById(@PathVariable("id") String id){

        Document result = censorService.findCensorById(id);
        if(result == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found any censor have id: " + id);
        } else return ResponseEntity.ok(result);
    }

    @GetMapping("")
    public ResponseEntity<?> getListCensorOfPost(@RequestParam(value = "pageNo", defaultValue = "1", required = false) int pageNo,
                                                 @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize){

        List<Document> result = censorService.findAllCensor(pageNo, pageSize);
        if(result.size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found any censor");
        } else return ResponseEntity.ok(result);
    }

    @PostMapping("")
    public ResponseEntity<?> createNewPost(@RequestBody Map<String, Object> censor){
        Document result = censorService.addNewPost(censor);
        //check valid input data
        if(censor.containsKey("target") && censor.containsKey("owner") && censor.containsKey("category") &&
                censor.containsKey("type") && censor.containsKey("lang") && censor.containsKey("content") &&
                censor.containsKey("level") && censor.containsKey("when")){

            if(result == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can not create new post");
            } else return ResponseEntity.status(HttpStatus.CREATED).body(result);

        } else throw new BadRequestException("Invalid input data");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editMediasOfPost(@PathVariable("id") String id, @RequestBody List<Map<String, Object>> medias){

        for(Map<String, Object> media : medias){
            media.forEach((key, value) -> {
                if(!media.containsKey("height") || !media.containsKey("path") || !media.containsKey("thumb")
                || !media.containsKey("type") || !media.containsKey("width") || !media.containsKey("id")){
                    throw new BadRequestException("Invalid data");
                }
            });
        }

        Document result = censorService.editMediasOfPost(id, medias);
        if(result == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can not create new post");
        } else return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCensorById(@PathVariable String id){
        DeleteResult result = censorService.deleteCensorById(id);
        if(result.getDeletedCount() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found any censor have id: " + id);
        }else{
            return ResponseEntity.ok("Delete successfully");
        }
    }
}
