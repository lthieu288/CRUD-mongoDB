package com.example.demo.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;
@Data
public class Censor {
    @Id
    private String id;
    private String target;
    private String owner;
    private String category;
    private String type;
    private String lang;
    private Integer level;
    private Date when;
    private Content content;
}
