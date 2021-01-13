package com.example.store.adapter.controller.dto;

import com.example.store.adapter.controller.ProductController;
import com.example.store.domain.Product;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class ProductConverterToDTO  extends RepresentationModelAssemblerSupport<ProductInputDTO, Product> {

    public ProductConverterToDTO() {
        super(ProductController.class, Product.class);
    }

    @Override
    public Product toModel(ProductInputDTO entity) {
        Product product = new Product();
        product.setName(entity.getName());
        product.setPrice(entity.getPrice());
        product.setManufacturingDate(entity.getManufacturingDate());
        product.setCategory(entity.getCategory());
        product.setQuantity(entity.getQuantity());

        return product;
    }
}