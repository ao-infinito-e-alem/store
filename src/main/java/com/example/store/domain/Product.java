package com.example.store.domain;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends RepresentationModel<Product> {

    private Long id;
    private String name;
    private LocalDate manufacturingDate;
    private double price;
    private Category category;
    private Integer quantity;

}