package com.example.store.adapter.controller;

import com.example.store.adapter.controller.dto.ProductDTO;
import com.example.store.adapter.controller.dto.ProductInputDTO;
import com.example.store.adapter.controller.dto.ProductDTOConverter;
import com.example.store.usecase.FindProduct;
import com.example.store.usecase.RegisterProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/products")
@RequiredArgsConstructor
public class ProductController {

    private final RegisterProduct registerProduct;

    private final FindProduct findProduct;

    private final ProductDTOConverter productDTOConverter;

    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ProductDTO registerProduct(@RequestBody ProductInputDTO productInputDTO){
        return productDTOConverter.toModel(registerProduct.registerProduct(productInputDTO));
    }

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public CollectionModel<ProductDTO> findProduct(@RequestParam String name){
        return productDTOConverter.toCollectionModel(findProduct.findProduct(name));
    }
}