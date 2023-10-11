package com.bda.carrental.controllers;

import com.bda.carrental.entities.ClientCompany;
import com.bda.carrental.entities.dto.ClientCompanyDto;
import com.bda.carrental.entities.dto.ClientDto;
import jakarta.persistence.PostUpdate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bda.carrental.services.ClientCompanyService;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class ClientCompanyController {

    private final ClientCompanyService clientCompanyService;

    public ClientCompanyController(ClientCompanyService clientCompanyService) {
        this.clientCompanyService = clientCompanyService;
    }
    @GetMapping
    public ResponseEntity<List<ClientCompanyDto>> getAll(){
        List<ClientCompanyDto> values = clientCompanyService.getAll();
        return ResponseEntity.ok(values);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClientCompanyDto> getById(@PathVariable("id") Long id) {
        ClientCompanyDto value = clientCompanyService.getById(id);
        return ResponseEntity.ok(value);
    }
    @PostMapping
    public ResponseEntity<Void> add(@RequestBody ClientCompanyDto entity) {
        clientCompanyService.add(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping
    public ResponseEntity<Void> update(@RequestBody ClientCompanyDto entity) {
        clientCompanyService.update(entity);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        clientCompanyService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
