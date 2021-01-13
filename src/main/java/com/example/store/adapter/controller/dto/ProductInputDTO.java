package com.example.store.adapter.controller.dto;

import com.example.store.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInputDTO extends RepresentationModel<ProductInputDTO> {

    private String name;
    private LocalDate manufacturingDate;
    private double price;
    private Category category;
    private Integer quantity;
}