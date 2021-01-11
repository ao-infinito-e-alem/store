package com.example.store.adapter.repository.dto;

import com.example.store.adapter.controller.ProductController;
import com.example.store.domain.Product;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class ProductDTOConverter extends RepresentationModelAssemblerSupport<Product, ProductDTO> {

    public ProductDTOConverter() {
        super(ProductController.class, ProductDTO.class);
    }


    @Override
    public ProductDTO toModel(Product entity) {
        var dto = createModelWithId(entity.getId(), entity);

        dto.setCategory(entity.getCategory());
        dto.setManufacturingDate(entity.getManufacturingDate());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setQuantity(entity.getQuantity());

        return dto;
    }
}