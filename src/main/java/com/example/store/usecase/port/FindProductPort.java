package com.example.store.usecase.port;

import com.example.store.domain.Product;

import java.util.List;

public interface FindProductPort {

    List<Product> findProduct(String name);
}
