package com.bda.carrental.entities.dto.transformations;

import com.bda.carrental.entities.ClientCompany;
import com.bda.carrental.entities.dto.ClientCompanyDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ClientCompanyDtoMapper implements Function<ClientCompany, ClientCompanyDto> {
    @Override
    public ClientCompanyDto apply(ClientCompany clientCompany) {
        return new ClientCompanyDto(clientCompany.getId(),
                clientCompany.getName(),
                clientCompany.getPhoneNumber(),
                clientCompany.getEmailContact());
    }
}
