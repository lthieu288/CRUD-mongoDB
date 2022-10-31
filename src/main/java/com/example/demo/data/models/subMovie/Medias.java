package com.example.demo.data.models.subMovie;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Medias {
    @Field("id")
    private String id;
    private Integer height;
    private String path;
    private String thumb;
    private Integer type;
    private Integer width;
}
