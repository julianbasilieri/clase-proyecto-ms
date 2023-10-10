package com.bda.carrental.entities.dto.transformations;

import com.bda.carrental.entities.Client;
import com.bda.carrental.entities.dto.ClientDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ClientDtoMapper implements Function<Client, ClientDto> {
    @Override
    public ClientDto apply(Client client) {
        return new ClientDto(client.getId(),
                client.getFirstName(),
                client.getLastName(),
                client.getSex(),
                client.getBirthDate());
    }
}
