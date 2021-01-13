package com.example.store.adapter.repository.gateway;

import com.example.store.adapter.repository.entity.ProductEntity;
import com.example.store.adapter.repository.mapper.ProductEntityMapper;
import com.example.store.domain.Product;
import com.example.store.usecase.port.FindProductPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class FindProductGateway implements FindProductPort {

    private final EntityManager entityManager;

    @Override
    @Transactional
    public List<Product> findProduct(String name) {
        var sql =  "from ProductEntity c " +
                "where c.name = :name";

        var products =  entityManager.createQuery(sql, ProductEntity.class)
                .setParameter("name", name)
                .getResultList();

        return products.stream().map(ProductEntityMapper::to).collect(Collectors.toList());
    }
}
