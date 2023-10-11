package com.bda.carrental.services;

import com.bda.carrental.entities.Vehicle;
import com.bda.carrental.entities.dto.VehicleDto;
import com.bda.carrental.entities.dto.transformations.VehicleDtoMapper;
import com.bda.carrental.entities.dto.transformations.VehicleMapper;
import com.bda.carrental.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
@Service
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;
    private final VehicleDtoMapper vehicleDtoMapper;
    private final VehicleMapper vehicleMapper;

    public VehicleServiceImpl(VehicleRepository vehicleRepository, VehicleDtoMapper vehicleDtoMapper, VehicleMapper vehicleMapper) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleDtoMapper = vehicleDtoMapper;
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    public void add(VehicleDto entity) {
        Vehicle vehicle = new Vehicle();
        vehicle.setYearModel(entity.getYearModel());
        vehicle.setBrandName(entity.getBrandName());
        vehicle.setCompact(entity.isCompact());
        vehicle.setDriverName(entity.getDriverName());
        vehicle.setCostHour(entity.getCostHour());
        vehicle.setTotalMiles(entity.getTotalMiles());
        vehicleRepository.save(vehicle);
    }

    @Override
    public VehicleDto getById(Long id) {
        Optional<Vehicle> value = vehicleRepository.findById(id);
        return value
                .map(vehicleDtoMapper)
                .orElseThrow();
    }

    @Override
    public List<VehicleDto> getAll() {
        List<Vehicle> values = vehicleRepository.findAll();
        return values
                .stream()
                .map(vehicleDtoMapper)
                .toList();
    }

    @Override
    public VehicleDto delete(Long id) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);
        optionalVehicle.ifPresent(vehicleRepository::delete);
        return optionalVehicle
                .map(vehicleDtoMapper)
                .orElseThrow();

    }

    @Override
    public void update(VehicleDto entity) {
        Optional<Vehicle> optionalVehicle = Stream.of(entity).map(vehicleMapper).findFirst();
        optionalVehicle.ifPresent(vehicleRepository::save);
    }
}
