package com.bda.carrental.entities.dto.transformations;

import com.bda.carrental.entities.Vehicle;
import com.bda.carrental.entities.dto.VehicleDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class VehicleMapper implements Function<VehicleDto, Vehicle> {

    @Override
    public Vehicle apply(VehicleDto vehicleDto) {
        return new Vehicle(vehicleDto.getId(),
                vehicleDto.getYearModel(),
                vehicleDto.getBrandName(),
                vehicleDto.isCompact(),
                vehicleDto.getDriverName(),
                vehicleDto.getCostHour(),
                vehicleDto.getTotalMiles());
    }
}
