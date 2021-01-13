package com.example.store.adapter.repository.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@NoArgsConstructor
public class BuyProductInDTO extends RepresentationModel<BuyProductInDTO> {

    private String name;
    private Integer quantity;
    private double payment;

    public BuyProductInDTO(String name, Integer quantity, double payment) {
        this.name = name;
        this.quantity = quantity;
        this.payment = payment;
    }
}
