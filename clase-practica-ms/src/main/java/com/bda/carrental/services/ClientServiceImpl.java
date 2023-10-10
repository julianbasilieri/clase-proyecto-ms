package com.bda.carrental.services;

import com.bda.carrental.entities.Client;
import com.bda.carrental.entities.ClientCompany;
import com.bda.carrental.entities.dto.ClientDto;
import com.bda.carrental.entities.dto.transformations.ClientCompanyDtoMapper;
import com.bda.carrental.entities.dto.transformations.ClientDtoMapper;
import com.bda.carrental.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientDtoMapper clientDtoMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ClientDtoMapper clientDtoMapper) {
        this.clientRepository = clientRepository;
        this.clientDtoMapper = clientDtoMapper;
    }


    @Override
    public void add(ClientDto entity) {
        Client client = new Client();
        client.setFirstName(entity.getFirstName());
        client.setLastName(entity.getLastName());
        client.setSex(entity.getSex());
        client.setBirthDate(entity.getBirthDate());
        clientRepository.save(client);
    }

    @Override
    public ClientDto getById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client
                .map(clientDtoMapper)
                .orElseThrow();
    }

    @Override
    public List<ClientDto> getAll() {
        List<Client> values = clientRepository.findAll();
        return values
                .stream()
                .map(clientDtoMapper)
                .toList();
    }

    @Override
    public ClientDto delete(Long id) {
        Optional<Client> optionalClient = clientRepository
                .findById(id);
        optionalClient.ifPresent(clientRepository::delete);
        return optionalClient
                .map(clientDtoMapper)
                .orElseThrow();
    }

    @Override
    public void update(ClientDto entity) {
        Optional<Client> optionalClient = clientRepository
                .findById(entity.getId());
        optionalClient.ifPresent(clientRepository::save);
    }
}
