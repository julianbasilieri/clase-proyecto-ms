package com.bda.carrental.repositories;

import com.bda.carrental.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository
        extends JpaRepository<Client, Long> {
}
