package com.example.store.adapter.repository.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@NoArgsConstructor
@Builder(toBuilder = true)
public class CategoryDTO extends RepresentationModel<CategoryDTO> {

    private String description;

    public CategoryDTO(String description) {
        this.description = description;
    }


}