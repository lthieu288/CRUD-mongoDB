package com.example.demo.data.models.subMovie;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Avatar {
    @Field("id")
    String id;
    String path;
    String thumb;
    String frame;
}
