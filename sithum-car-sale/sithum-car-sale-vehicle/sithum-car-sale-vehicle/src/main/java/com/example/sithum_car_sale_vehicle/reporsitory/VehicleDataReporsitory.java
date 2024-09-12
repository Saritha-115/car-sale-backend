package com.example.sithum_car_sale_vehicle.reporsitory;

import com.example.sithum_car_sale_vehicle.model.VehicleDataModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDataReporsitory extends JpaRepository<VehicleDataModel,Long> {
}
