package com.example.store.usecase;

import com.example.store.adapter.repository.ProductRepository;
import com.example.store.adapter.controller.dto.BuyProductInDTO;
import com.example.store.adapter.controller.dto.BuyProductOutDTO;
import com.example.store.domain.Product;
import com.example.store.usecase.exception.NotAcceptableException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuyProduct {

    private final FindProduct findProduct;

    private final ProductRepository productRepository;

    public BuyProductOutDTO buyProduct(BuyProductInDTO buyProductInDTO){

        BuyProductOutDTO buyProductOutDTO = new BuyProductOutDTO();

        List<Product> product = findProduct.findProduct(buyProductInDTO.getName());

        buyProductOutDTO.setName(product.get(0).getName());

        if(product.get(0).getQuantity() < buyProductInDTO.getQuantity()){
            throw new NotAcceptableException("inventory volume does not support this quantity");
        }

        productRepository.updateQuantity(buyProductInDTO.getQuantity(), buyProductInDTO.getName());

        buyProductOutDTO.setQuantity(buyProductInDTO.getQuantity());

        if(buyProductInDTO.getPayment() < (product.get(0).getPrice() * buyProductInDTO.getQuantity())){
            throw new NotAcceptableException("payment is not enough to complete the purchase");
        }

        buyProductOutDTO.setChange(buyProductInDTO.getPayment() - (product.get(0).getPrice() * buyProductInDTO.getQuantity()));

        return buyProductOutDTO;
    }
}
