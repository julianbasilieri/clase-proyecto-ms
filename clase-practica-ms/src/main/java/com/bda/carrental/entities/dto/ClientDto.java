package com.bda.carrental.entities.dto;

import com.bda.carrental.entities.ClientCompany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    private long id;
    private String firstName;
    private String lastName;
    private String sex;
    private LocalDateTime birthDate;
}
