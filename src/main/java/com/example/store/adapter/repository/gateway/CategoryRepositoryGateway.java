package com.example.store.adapter.repository.gateway;

import com.example.store.adapter.repository.CategoryRepository;
import com.example.store.adapter.repository.entity.CategoryEntity;
import com.example.store.adapter.repository.mapper.CategoryEntityMapper;
import com.example.store.domain.Category;
import com.example.store.usecase.port.FindCategoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryGateway implements FindCategoryPort {

    private final EntityManager entityManager;

    @Override
    @Transactional
    public List<Category> findByDescriptionLike(String description){
        var sql = "from CategoryEntity c " +
                "where c.description like :description";


        var categories = entityManager.createQuery(sql, CategoryEntity.class)
                .setParameter("description", "%" + description + "%")
                .getResultList();

        return categories.stream().map(CategoryEntityMapper::to).collect(Collectors.toList());

    }

}