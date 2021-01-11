package com.example.store.usecase.port;

import com.example.store.adapter.repository.entity.ProductEntity;
import com.example.store.domain.Product;

public interface RegisterProductPort {
    Product registerProduct(ProductEntity productEntity);
}