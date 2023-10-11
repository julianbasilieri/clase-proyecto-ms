package com.bda.carrental.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {
    private long id;
    private int yearModel;
    private String brandName;
    private boolean compact;
    private String driverName;
    private float costHour;
    private float totalMiles;
}
