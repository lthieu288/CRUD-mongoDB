package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDTO {
    String code;
    String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Map<String, String> beanValidation;

    public ErrorResponseDTO(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

}

