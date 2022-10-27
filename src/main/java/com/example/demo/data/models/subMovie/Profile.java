package com.example.demo.data.models.subMovie;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Profile {
    @Field("id")
    String id;
    String name;
    Avatar avatar;
}
