package com.example.store.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private LocalDate date =  LocalDate.of(1999,9,23);

    private Category category = new Category().builder()
            .id(1l)
            .description("balls")
            .build();

    @Test
    public void testGets(){
        Product product = new Product().builder()
                .id(1l)
                .name("Soccer Ball")
                .category(category)
                .manufacturingDate(date)
                .price(12.00)
                .build();

        assertEquals(1l, product.getId());
        assertEquals("Soccer Ball", product.getName());
        assertEquals(category, product.getCategory());
        assertEquals(date, product.getManufacturingDate());
        assertEquals(12.00, product.getPrice());
    }

    @Test
    public void testSets(){
        Product product = new Product();
        product.setId(1l);
        product.setName("Soccer Ball");
        product.setCategory(category);
        product.setManufacturingDate(date);
        product.setPrice(12.00);

        assertEquals(1l, product.getId());
        assertEquals("Soccer Ball", product.getName());
        assertEquals(category, product.getCategory());
        assertEquals(date, product.getManufacturingDate());
        assertEquals(12.00, product.getPrice());
    }
}