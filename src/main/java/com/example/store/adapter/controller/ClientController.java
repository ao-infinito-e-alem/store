package com.example.store.adapter.controller;

import com.example.store.adapter.repository.dto.ClientDTO;
import com.example.store.adapter.repository.dto.ClientDTOConverter;
import com.example.store.adapter.repository.dto.ClientInputDTO;
import com.example.store.usecase.FindClient;
import com.example.store.usecase.RegisterClient;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.ObjectUtils.isEmpty;

@RestController
@RequestMapping(path = "/clients")
@RequiredArgsConstructor
public class ClientController {

    private final FindClient findClient;

    private final ClientDTOConverter clientDTOConverter;

    private final RegisterClient registerClient;

    @GetMapping(path = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ClientDTO findClientById(@PathVariable Long id){
        return clientDTOConverter.toModel(findClient.findClientById(id));
    }

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public CollectionModel<ClientDTO> findClientByName(@RequestParam(required = false) String name){

        if(!isEmpty(name)) {
            return clientDTOConverter.toCollectionModel(findClient.findClientByName(name));
        }

        return clientDTOConverter.toCollectionModel(findClient.findAll());
    }

    /*@GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public CollectionModel<ClientDTO> findAllClients(){
        return clientDTOConverter.toCollectionModel(findClient.findAll());
    }*/

    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ClientDTO registerClient(@RequestBody ClientInputDTO client){
        return  clientDTOConverter.toModel(registerClient.registerClient(client));
    }
}