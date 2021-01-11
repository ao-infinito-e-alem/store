package com.example.store.adapter.controller;

import com.example.store.adapter.repository.dto.ProductDTO;
import com.example.store.adapter.repository.dto.ProductInputDTO;
import com.example.store.adapter.repository.dto.ProductDTOConverter;
import com.example.store.usecase.RegisterProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/products")
@RequiredArgsConstructor
public class ProductController {

    private final RegisterProduct registerProduct;

    private final ProductDTOConverter productDTOConverter;

    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ProductDTO registerProduct(@RequestBody ProductInputDTO productInputDTO){
        return productDTOConverter.toModel(registerProduct.registerProduct(productInputDTO));
    }
}