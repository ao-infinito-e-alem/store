package com.example.store.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    private Long id;

    private String description;
}