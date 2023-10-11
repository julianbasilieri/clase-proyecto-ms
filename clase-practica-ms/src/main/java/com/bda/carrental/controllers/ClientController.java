package com.bda.carrental.controllers;

import com.bda.carrental.entities.dto.ClientDto;
import com.bda.carrental.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> getAll() {
        List<ClientDto> values = clientService.getAll();
        return ResponseEntity.ok(values);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getById(@PathVariable("id") Long id) {
        ClientDto value = clientService.getById(id);
        return ResponseEntity.ok(value);
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody ClientDto entity) {
        clientService.add(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody ClientDto entity) {
        clientService.update(entity);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        clientService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
