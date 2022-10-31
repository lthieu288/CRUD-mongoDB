package com.example.demo.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "employees")
public class ObjectDto {
    @Id
    String id;
    String target;
    String owner;
    String category;
    String lang;
    ContentOfPost content;
    String type;
    Integer level;
    Date when;
}
