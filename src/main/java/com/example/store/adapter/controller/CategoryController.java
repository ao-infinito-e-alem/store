package com.example.store.adapter.controller;

import com.example.store.adapter.controller.dto.CategoryDTO;
import com.example.store.adapter.controller.dto.CategoryDTOConverter;
import com.example.store.usecase.FindCategory;
import com.example.store.usecase.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/category")
@RequiredArgsConstructor
public class CategoryController {

    private final FindCategory findCategory;

    private final CategoryDTOConverter categoryDTOConverter;

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public List<CategoryDTO> findCategory(@RequestParam String description) throws NotFoundException {

        return findCategory.findCategory(description).stream()
                .map(categoryDTOConverter::toModel)
                .collect(Collectors.toList());

    }

}