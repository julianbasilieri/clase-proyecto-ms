package com.bda.carrental.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Vehicules")
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(generator = "Vehicules")
    @TableGenerator(name = "Vehicules", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue = "id",
            initialValue = 1, allocationSize = 1)

    private long id;

    @Column(name = "year_model")
    private int yearModel;

    @Column(name = "brand_name")
    private String brandName;

    private boolean compact;

    @Column(name = "driver_name")
    private String driverName;

    @Column(name = "cost_hour")
    private float costHour;

    @Column(name = "total_miles")
    private float totalMiles;
}
