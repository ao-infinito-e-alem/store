package com.example.store.adapter.controller.dto;

import com.example.store.adapter.controller.CategoryController;
import com.example.store.domain.Category;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class CategoryDTOConverter extends RepresentationModelAssemblerSupport<Category, CategoryDTO> {

    public CategoryDTOConverter() {
        super(CategoryController.class, CategoryDTO.class);
    }

    @Override
    public CategoryDTO toModel(Category entity) {

        var dto = createModelWithId(entity.getId(), entity);

        dto.setDescription(entity.getDescription());

        return dto;
    }

}
