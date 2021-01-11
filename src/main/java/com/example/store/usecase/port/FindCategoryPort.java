package com.example.store.usecase.port;

import com.example.store.domain.Category;

import java.util.List;

public interface FindCategoryPort {

    List<Category> findByDescriptionLike(String description);
}