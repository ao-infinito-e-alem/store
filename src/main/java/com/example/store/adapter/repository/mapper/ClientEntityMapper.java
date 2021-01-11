package com.example.store.adapter.repository.mapper;

import com.example.store.adapter.repository.entity.ClientEntity;
import com.example.store.domain.Client;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor
public class ClientEntityMapper {
    private static final ModelMapper mapper = new ModelMapper();

    public static ClientEntity from(Client client){
        return mapper.map(client, ClientEntity.class);
    }

    public static Client to(ClientEntity clientEntity) {
        return mapper.map(clientEntity, Client.class);
    }
}