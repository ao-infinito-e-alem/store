package com.example.store.adapter.repository;

import com.example.store.adapter.repository.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
}