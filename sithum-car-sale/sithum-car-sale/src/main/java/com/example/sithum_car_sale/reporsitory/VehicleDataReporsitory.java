package com.example.sithum_car_sale.reporsitory;

import com.example.sithum_car_sale.model.VehicleDataModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDataReporsitory extends JpaRepository<VehicleDataModel,Long> {

}
