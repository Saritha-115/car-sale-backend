package com.example.sithum_car_sale_vehicle.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "vehicle_data")
public class VehicleDataModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "vehicle_brand",nullable = false)
    private String vehicleBrand;

    @Column(name = "engine_capacity")
    private String engineCap;

    @Column(name = "year")
    private int year;

    @Column(name = "price")
    private double price;

    @Column(name = "phone_number")
    private String phoneNum;

    @Column(name = "description")
    private String description;

    @Lob
    @Column(name = "vehicle_image", columnDefinition = "BLOB")
    private byte[] vehicleImg;
}
