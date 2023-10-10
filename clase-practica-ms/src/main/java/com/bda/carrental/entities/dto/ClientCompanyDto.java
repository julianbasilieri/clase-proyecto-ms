package com.bda.carrental.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientCompanyDto {

    private long id;
    private String name;
    private String phoneNumber;
    private String emailContact;

}
