package com.example.store.usecase.port;

import com.example.store.adapter.repository.entity.ClientEntity;
import com.example.store.domain.Client;

public interface RegisterClientPort {
    Client registerClient(ClientEntity client);
}