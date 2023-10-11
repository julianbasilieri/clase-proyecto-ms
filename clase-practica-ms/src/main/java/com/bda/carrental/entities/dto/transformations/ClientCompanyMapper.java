package com.bda.carrental.entities.dto.transformations;

import com.bda.carrental.entities.ClientCompany;
import com.bda.carrental.entities.dto.ClientCompanyDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.function.Function;

@Service
public class ClientCompanyMapper implements Function<ClientCompanyDto, ClientCompany> {
    @Override
    public ClientCompany apply(ClientCompanyDto clientCompanyDto) {
        return new ClientCompany(clientCompanyDto.getId(),
                clientCompanyDto.getName(),
                clientCompanyDto.getPhoneNumber(),
                clientCompanyDto.getEmailContact(),
                new ArrayList<>());
    }
}
