package com.example.store.usecase;

import com.example.store.domain.Product;
import com.example.store.usecase.exception.NotFoundException;
import com.example.store.usecase.port.FindProductPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindProduct {

    private final FindProductPort findProductPort;

    public List<Product> findProduct (String name){
        List<Product> products = findProductPort.findProduct(name);

        if(products.isEmpty()){
            throw new NotFoundException("No products with this name");
        }

        return products;
    }
}
