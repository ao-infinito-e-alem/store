package com.example.store.adapter.repository;

import com.example.store.adapter.repository.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Transactional
    @Modifying
    @Query(value = "update ProductEntity set quantity = quantity - :quantity where name = :name")
    void updateQuantity(@Param("quantity") Integer quantity, @Param("name") String name);
}