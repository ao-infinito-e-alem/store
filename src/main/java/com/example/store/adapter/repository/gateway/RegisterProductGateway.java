package com.example.store.adapter.repository.gateway;

import com.example.store.adapter.repository.ProductRepository;
import com.example.store.adapter.repository.entity.ProductEntity;
import com.example.store.adapter.repository.mapper.ProductEntityMapper;
import com.example.store.domain.Product;
import com.example.store.usecase.port.RegisterProductPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RegisterProductGateway implements RegisterProductPort {

    private final ProductRepository productRepository;

    @Override
    public Product registerProduct(ProductEntity productEntity) {
        return ProductEntityMapper.to(productRepository.save(productEntity));
    }
}