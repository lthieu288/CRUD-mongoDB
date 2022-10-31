package com.example.demo.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "employees")
public class CensorOfComment {
    @Id
    private String id;
    private String target;
    private String owner;
    private String category;
    private String type;
    private String lang;
    private Integer level;
    private Date when;
    private CensorOfComment content;
    private String assignDate;
    private String user;
}
