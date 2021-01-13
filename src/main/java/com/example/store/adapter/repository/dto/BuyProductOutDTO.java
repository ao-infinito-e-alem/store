package com.example.store.adapter.repository.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@NoArgsConstructor
public class BuyProductOutDTO extends RepresentationModel<BuyProductOutDTO> {

    private String name;
    private Integer quantity;
    private double change;

    public BuyProductOutDTO(String name, Integer quantity, double change) {
        this.name = name;
        this.quantity = quantity;
        this.change = change;
    }
}
