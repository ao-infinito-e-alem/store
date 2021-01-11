package com.example.store.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientTest {

    private LocalDate date =  LocalDate.of(1999,9,23);

    @Test
    public void testGets(){

        Client client = new Client().builder()
                .id(1l)
                .name("Luis")
                .cpf("10456534290")
                .birthDate(date)
                .build();
        assertEquals(1l, client.getId());
        assertEquals("Luis", client.getName());
        assertEquals("10456534290", client.getCpf());
        assertEquals(date, client.getBirthDate());
    }

    @Test
    public void testSets(){
        Client client = new Client();
        client.setId(1l);
        client.setName("Luis");
        client.setCpf("10456534290");
        client.setBirthDate(date);

        assertEquals(1l, client.getId());
        assertEquals("Luis", client.getName());
        assertEquals("10456534290", client.getCpf());
        assertEquals(date, client.getBirthDate());
    }
}