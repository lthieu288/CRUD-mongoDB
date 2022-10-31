package com.example.demo.controllers;

import com.example.demo.data.models.ObjectDto;
import com.example.demo.data.models.subMovie.Medias;
import com.example.demo.exception.BadRequestException;
import com.example.demo.services.ObjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/object")
@RequiredArgsConstructor
public class ObjectController {

    private final ObjectService objectService;

    @PutMapping("/{id}")
    public ResponseEntity<?> pushNewField(@PathVariable("id") String id ,
                                          @RequestParam(value = "fieldValue") String fieldValue,
                                          @RequestParam(value = "fieldName") String fieldName,
                                          @RequestParam(value = "cond") String valueCondition){
        ObjectDto object = objectService.pushNewField(id, fieldName, fieldValue, valueCondition);
        if(object == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found any object have id: " + id);
        } else return ResponseEntity.ok(object);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteField(@PathVariable("id") String id ,
                                         @RequestParam(value = "fieldName") String fieldName,
                                         @RequestParam(value = "cond") String valueCondition){

        //check type from input
        if(id.getClass() != String.class || fieldName.getClass() != String.class || valueCondition.getClass() != String.class){
            throw new BadRequestException("Invalid input");
        }
        ObjectDto object = objectService.deleteField(id, fieldName, valueCondition);
        if(object == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found any object have id: " + id);
        } else return ResponseEntity.ok(object);
    }

    @PutMapping("/medias/{id}")
    public ResponseEntity<?> pushNewField(@PathVariable("id") String id, @RequestBody Medias medias){
        if(medias.getClass() == Medias.class){
            throw new BadRequestException("Invalid input");
        }

        ObjectDto object = objectService.pushToMedias(id, medias);
        if(object == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found any object have id: " + id);
        } else return ResponseEntity.ok(object);
    }

}
