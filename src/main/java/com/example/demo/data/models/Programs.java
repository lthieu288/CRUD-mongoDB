package com.example.demo.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
public class Programs {
    private List<String> acl;
    @Field("401K_contrib")
    private Integer contrib;
    @Field("health_plan")
    private Boolean healthPlan;
    private Double spp;
}
