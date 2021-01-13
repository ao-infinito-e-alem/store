package com.example.store.usecase;

import com.example.store.adapter.controller.dto.ClientConverterToDTO;
import com.example.store.adapter.controller.dto.ClientInputDTO;
import com.example.store.adapter.repository.mapper.ClientEntityMapper;
import com.example.store.domain.Client;
import com.example.store.usecase.port.RegisterClientPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterClient {

    private final RegisterClientPort registerClientPort;

    private final ClientConverterToDTO clientConverterToDTO;

    public Client registerClient(ClientInputDTO client) {
        return registerClientPort.registerClient(ClientEntityMapper.from(clientConverterToDTO.toModel(client)));
    }
}