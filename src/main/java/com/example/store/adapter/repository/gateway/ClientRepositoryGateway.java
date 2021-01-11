package com.example.store.adapter.repository.gateway;

import com.example.store.adapter.repository.ClientRepository;
import com.example.store.adapter.repository.entity.ClientEntity;
import com.example.store.adapter.repository.mapper.ClientEntityMapper;
import com.example.store.domain.Client;
import com.example.store.usecase.exception.NotFoundException;
import com.example.store.usecase.port.FindClientPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryGateway implements FindClientPort {

    private final ClientRepository clientRepository;

    private final EntityManager entityManager;

    @Override
    @Transactional
    public Client findClientId(Long id) {
        var client = clientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Client not found"));

        return ClientEntityMapper.to(client);
    }

    @Override
    @Transactional
    public List<Client> findClientName(String name) {
        var sql =  "from ClientEntity c " +
                "where c.name = :name";

        var clients =  entityManager.createQuery(sql, ClientEntity.class)
                .setParameter("name", name)
                .getResultList();

        return clients.stream().map(ClientEntityMapper::to).collect(Collectors.toList());
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll().stream()
                .map(ClientEntityMapper::to)
                .collect(Collectors.toList());
    }
}