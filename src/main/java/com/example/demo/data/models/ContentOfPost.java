package com.example.demo.data.models;

import com.example.demo.data.models.subMovie.Medias;
import com.example.demo.data.models.subMovie.Profile;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ContentOfPost extends Content{
    private String id;
    private String scope;
    private String owner;
    private String typpost;
    private String actor;
    private List<Medias> medias;
    private String target;
    private String dl147;
    private Date dl146;
    private Date when;
    private String lang;
    private String langDefault;
    private Integer isShare;
    private Profile profile;
}
