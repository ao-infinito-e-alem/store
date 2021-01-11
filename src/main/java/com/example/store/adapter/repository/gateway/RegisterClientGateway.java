package com.example.store.adapter.repository.gateway;

import com.example.store.adapter.repository.ClientRepository;
import com.example.store.adapter.repository.entity.ClientEntity;
import com.example.store.adapter.repository.mapper.ClientEntityMapper;
import com.example.store.domain.Client;
import com.example.store.usecase.port.RegisterClientPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RegisterClientGateway implements RegisterClientPort {

    private final ClientRepository clientRepository;

    @Override
    public Client registerClient(ClientEntity client) {
        return ClientEntityMapper.to(clientRepository.save(client));
    }
}