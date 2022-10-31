package com.example.demo.controllers;

import com.example.demo.data.models.CensorOfPost;
import com.example.demo.data.models.subMovie.Medias;
import com.example.demo.exception.BadRequestException;
import com.example.demo.services.CensorService;
import com.mongodb.client.result.DeleteResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/censor")
@RequiredArgsConstructor
public class CensorController {

    private final CensorService censorService;

    @PostMapping("")
    public ResponseEntity<?> createNewPost(@RequestBody CensorOfPost censorOfPost){

        if(censorOfPost.getClass() != CensorOfPost.class){
            throw new BadRequestException("Invalid data");
        }

        CensorOfPost result = censorService.addNewPost(censorOfPost);
        if(result == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can not create new post");
        } else return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editMediasOfPost(@PathVariable("id") String id, @RequestBody List<Medias> medias){

        for(Medias media : medias){
            if(media.getClass() != Medias.class)
                throw new BadRequestException("Invalid input");
        }

        CensorOfPost result = censorService.editMediasOfPost(id, medias);
        if(result == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can not create new post");
        } else return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCensorOfPostById(@PathVariable("id") String id){

        CensorOfPost result = censorService.findPostById(id);
        if(result == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found any censor have id: " + id);
        } else return ResponseEntity.ok(result);
    }
    @GetMapping("")
    public ResponseEntity<?> getListCensorOfPost(@RequestParam(value = "pageNo", defaultValue = "1", required = false) int pageNo,
                                                 @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize){

        List<CensorOfPost> result = censorService.findAllCensorOfPost(pageNo, pageSize);
        if(result == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found any censor");
        } else return ResponseEntity.ok(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCensorOfPostById(@PathVariable String id){
        DeleteResult result = censorService.deleteCensorOfPostById(id);
        if(result.getDeletedCount() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found any censor have id: " + id);
        }else{
            return ResponseEntity.ok("Delete successfully");
        }
    }
}
