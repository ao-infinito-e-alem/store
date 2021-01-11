package com.example.store.adapter.service;

import com.example.store.adapter.repository.dto.CategoryDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryService;

    @Test
    public void givenObjectJavaReturnJson() throws JsonProcessingException {
        var categoryDto = CategoryDTO.builder()
                .description("balls")
                .build();

        String json = categoryService.javaToJson(categoryDto);
        assertThat(json, containsString("balls"));
        System.out.println(json);
    }

    @Test
    public void givenJsonReturnObjectJava() throws JsonProcessingException {
        String json = "{\"description\":\"balls\",\"links\":[]}";
        var categoryDto = categoryService.jsonToJava(json);
        assertThat(categoryDto.getDescription(), equalTo("balls"));
        System.out.println(categoryDto);
    }
}