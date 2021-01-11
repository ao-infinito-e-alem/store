package com.example.store.usecase;

import com.example.store.domain.Client;
import com.example.store.usecase.exception.NotFoundException;
import com.example.store.usecase.port.FindClientPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindClient {

    private final FindClientPort findClientPort;

    public Client findClientById(Long id) {
        return findClientPort.findClientId(id);
    }

    public List<Client> findClientByName(String name) {

        List<Client> clients = findClientPort.findClientName(name);

        if(clients.isEmpty()){
            throw new NotFoundException("No clients with this name");
        }

        return clients;
    }

    public List<Client> findAll() {
        return findClientPort.findAll();
    }
}