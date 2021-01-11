package com.example.store.adapter.repository.mapper;
import com.example.store.adapter.repository.entity.CategoryEntity;
import com.example.store.domain.Category;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor
public class CategoryEntityMapper {

    private static final ModelMapper mapper = new ModelMapper();

    public static CategoryEntity from(Category category){
        return mapper.map(category, CategoryEntity.class);
    }

    public static Category to(CategoryEntity categoryEntity) {
        return mapper.map(categoryEntity, Category.class);
    }
}