package com.example.store.adapter.repository.dto;

import com.example.store.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO extends RepresentationModel<ProductDTO> {

    private String name;
    private LocalDate manufacturingDate;
    private double price;
    private Category category;
    private Integer quantity;
}