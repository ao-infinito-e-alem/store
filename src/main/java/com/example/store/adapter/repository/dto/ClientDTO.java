package com.example.store.adapter.repository.dto;

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
public class ClientDTO extends RepresentationModel<ClientDTO> {

    private String name;
    private String cpf;
    private Integer age;
    private LocalDate birthDate;

}