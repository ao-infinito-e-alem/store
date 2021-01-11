package com.example.store.adapter.service;

import com.example.store.adapter.repository.dto.CategoryDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CategoryService {

    private ObjectMapper objectMapper = new ObjectMapper();

    public String javaToJson(CategoryDTO categoryDTO) throws JsonProcessingException {
        return objectMapper.writeValueAsString(categoryDTO);
    }

    public CategoryDTO jsonToJava(String json) throws JsonProcessingException {
        return objectMapper.readValue(json, CategoryDTO.class);
    }

    public String jsonNode(String json) throws JsonProcessingException {
        JsonNode jsonNode =  objectMapper.readTree(json);
        return jsonNode.get("description").asText();
    }
}