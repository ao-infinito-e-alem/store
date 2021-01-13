package com.example.store.adapter.controller;

import com.example.store.adapter.controller.dto.BuyProductInDTO;
import com.example.store.adapter.controller.dto.BuyProductOutDTO;
import com.example.store.usecase.BuyProduct;
import lombok.RequiredArgsConstructor;
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
    public BuyProductOutDTO buyProduct(@RequestBody BuyProductInDTO buyProductInDTO){
        return buyProduct.buyProduct(buyProductInDTO);
    }

}
