package com.example.store.usecase.port;

import com.example.store.domain.Client;

import java.util.List;

public interface FindClientPort {

    Client findClientId(Long id);

    List<Client> findClientName(String name);

    List<Client> findAll();
}