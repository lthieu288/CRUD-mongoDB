package com.example.demo.services;

import com.example.demo.data.models.ObjectDto;
import com.example.demo.data.models.subMovie.Medias;

public interface ObjectService {
    ObjectDto pushNewField(String id, String fieldName, String fieldValue, String valueCondition);
    ObjectDto deleteField(String id, String fieldName, String valueCondition);
    ObjectDto pushToMedias(String id, Medias medias);
}
