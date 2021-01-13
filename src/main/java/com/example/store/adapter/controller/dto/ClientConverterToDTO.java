package com.example.store.adapter.controller.dto;

import com.example.store.adapter.controller.ClientController;
import com.example.store.domain.Client;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class ClientConverterToDTO  extends RepresentationModelAssemblerSupport<ClientInputDTO, Client> {

    public ClientConverterToDTO() {
        super(ClientController.class, Client.class);
    }

    @Override
    public Client toModel(ClientInputDTO entity) {
        Client client = new Client();

        client.setBirthDate(entity.getBirthDate());
        client.setCpf(entity.getCpf());
        client.setName(entity.getName());
        client.setAge(entity.getAge());

        return client;
    }
}