package com.example.store.adapter.repository.mapper;

import com.example.store.adapter.repository.entity.ClientEntity;
import com.example.store.adapter.repository.entity.ProductEntity;
import com.example.store.domain.Client;
import com.example.store.domain.Product;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor
public class ProductEntityMapper {
    private static final ModelMapper mapper = new ModelMapper();

    public static ProductEntity from(Product product){
        return mapper.map(product, ProductEntity.class);
    }

    public static Product to(ProductEntity productEntity) {
        return mapper.map(productEntity, Product.class);
    }

}