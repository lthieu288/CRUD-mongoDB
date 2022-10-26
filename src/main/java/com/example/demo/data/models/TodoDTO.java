package com.example.demo.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Document(collection = "todos")
public class TodoDTO {
    @Id
    private String id;
    @NotBlank(message = "Must have name for todo")
    private String todo;
    @NotBlank(message = "Must have description for todo")
    private String description;
    private Boolean completed;
    private LocalDateTime createdDate;
}
