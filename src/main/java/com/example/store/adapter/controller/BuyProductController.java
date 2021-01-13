package com.example.store.adapter.controller;

import com.example.store.adapter.repository.dto.BuyProductInDTO;
import com.example.store.adapter.repository.dto.BuyProductOutDTO;
import com.example.store.usecase.BuyProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/buy")
@RequiredArgsConstructor
public class BuyProductController {

    private final BuyProduct buyProduct;

    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public CollectionModel<BuyProductOutDTO> buyProduct(@RequestBody BuyProductInDTO buyProductInDTO){
        return buyProduct.buyProduct(buyProductInDTO);
    }

}
