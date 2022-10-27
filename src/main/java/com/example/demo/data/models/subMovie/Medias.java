package com.example.demo.data.models.subMovie;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Medias {
    @Field("id")
    String id;
    Integer height;
    String path;
    String thumb;
    Integer type;
    Integer width;
}
