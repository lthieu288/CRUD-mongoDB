package com.example.demo.data.models;

import com.example.demo.data.models.subMovie.Medias;
import com.example.demo.data.models.subMovie.Profile;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Data
public class Content {
    @Id
    String id;
    String scope;
    String owner;
    String typpost;
    String actor;
    String content;
    String target;
    String dl147;
    Date dl146;
    Date when;
    String lang;
    String langDefault;
    Integer isShare;
    List<Medias> medias;
    Profile profile;
}
