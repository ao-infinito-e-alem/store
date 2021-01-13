package com.example.store.usecase;

import com.example.store.adapter.controller.dto.ProductConverterToDTO;
import com.example.store.adapter.controller.dto.ProductInputDTO;
import com.example.store.adapter.repository.mapper.ProductEntityMapper;
import com.example.store.domain.Product;
import com.example.store.usecase.port.RegisterProductPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterProduct {

    private final RegisterProductPort registerProductPort;

    private final ProductConverterToDTO productConverterToDTO;

    public Product registerProduct(ProductInputDTO productInputDTO) {
        return registerProductPort.registerProduct(ProductEntityMapper.from(productConverterToDTO.toModel(productInputDTO)));
    }
}