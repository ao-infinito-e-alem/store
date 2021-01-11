package com.example.store.usecase;

import com.example.store.domain.Category;
import com.example.store.usecase.exception.NotFoundException;
import com.example.store.usecase.port.FindCategoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindCategory {

    private final FindCategoryPort findCategoryPort;


    public List<Category> findCategory(String description) throws NotFoundException {
        List<Category> categories = findCategoryPort.findByDescriptionLike(description);

        if(categories.isEmpty()){
            throw new NotFoundException("Non-existent category on Database!");
        }

        return categories;
    }

}