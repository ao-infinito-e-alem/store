package com.example.store.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryTest {

    @Test
    public void testGets(){
        Category category = new Category().builder()
                .id(1l)
                .description("balls")
                .build();
        assertEquals(1l, category.getId());
        assertEquals("balls", category.getDescription());
    }

    @Test
    public void testSets(){
        Category category = new Category();
        category.setId(1l);
        category.setDescription("balls");

        assertEquals(1l, category.getId());
        assertEquals("balls", category.getDescription());
    }
}