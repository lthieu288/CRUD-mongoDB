package com.example.demo.data.models;

import com.example.demo.data.models.subMovie.Profile;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
public class ContentOfComment {
    private String id;
    private String lang;
    private Date dl146;
    private String dl147;
    private String owner;
    @Field("owntarget")
    private String ownTarget;
    @Field("ownsource")
    private String ownSource;
    private String target;
    private String source;
    private String type;
    private String content;
    private Date when;
    private Profile profile;
    private String actor;

}
