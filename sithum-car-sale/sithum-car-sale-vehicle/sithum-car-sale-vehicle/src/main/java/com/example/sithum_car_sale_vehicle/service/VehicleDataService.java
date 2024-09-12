package com.example.sithum_car_sale_vehicle.service;

import com.example.sithum_car_sale_vehicle.model.VehicleDataModel;

import java.util.List;

public interface VehicleDataService {
    VehicleDataModel saveVehicleData(VehicleDataModel vehicleDataModel);
    List<VehicleDataModel> getAllVehicleData();
    VehicleDataModel getVehicleDataById(long id);
    VehicleDataModel updateVehicleData(VehicleDataModel vehicleDataModel,long id);
    void deleteVehicleData(long id);
}
