package com.bda.carrental.repositories;

import com.bda.carrental.entities.ClientCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientCompanyRepository
        extends JpaRepository<ClientCompany, Long> {
}
