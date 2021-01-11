package com.example.store.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client extends RepresentationModel<Client> {

    private Long id;

    private String name;

    private String cpf;

    private LocalDate birthDate;

    private Integer age;
}