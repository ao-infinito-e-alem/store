package com.example.store.adapter.controller.dto;

import com.example.store.adapter.controller.ClientController;
import com.example.store.domain.Client;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class ClientDTOConverter extends RepresentationModelAssemblerSupport<Client, ClientDTO> {

    public ClientDTOConverter() {
        super(ClientController.class, ClientDTO.class);
    }

    @Override
    public ClientDTO toModel(Client entity) {
        var dto = createModelWithId(entity.getId(), entity);

        dto.setBirthDate(entity.getBirthDate());
        dto.setCpf(entity.getCpf());
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());

        return dto;
    }
}