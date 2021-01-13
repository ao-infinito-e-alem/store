package com.example.store.adapter.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientInputDTO extends RepresentationModel<ClientInputDTO> {

    private String name;
    private String cpf;
    private Integer age;
    private LocalDate birthDate;

}