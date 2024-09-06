package com.example.sithum_car_sale_vehicle.service.impl;

import com.example.sithum_car_sale_vehicle.exception.ResourceNotFoundException;
import com.example.sithum_car_sale_vehicle.model.VehicleDataModel;
import com.example.sithum_car_sale_vehicle.reporsitory.VehicleDataReporsitory;
import com.example.sithum_car_sale_vehicle.service.VehicleDataService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleDataServiceImpl implements VehicleDataService {
    private VehicleDataReporsitory vehicleDataReporsitory;

    public VehicleDataServiceImpl(VehicleDataReporsitory vehicleDataReporsitory) {
        super();
        this.vehicleDataReporsitory = vehicleDataReporsitory;
    }

    @Override
    public List<VehicleDataModel> getAllVehicleData() {
        return vehicleDataReporsitory.findAll();
    }

    @Override
    public VehicleDataModel getVehicleDataById(long id) {
        return vehicleDataReporsitory.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Vehicle Data","Id",id));
    }

    @Override
    public VehicleDataModel updateVehicleData(VehicleDataModel vehicleDataModel, long id) {

        VehicleDataModel existingVehicleData = vehicleDataReporsitory.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Vehicle Data","Id",id));

        existingVehicleData.setVehicleBrand(vehicleDataModel.getVehicleBrand());
        existingVehicleData.setVehicleImg(vehicleDataModel.getVehicleImg());
        existingVehicleData.setDescription(vehicleDataModel.getDescription());
        existingVehicleData.setEngineCap(vehicleDataModel.getEngineCap());
        existingVehicleData.setYear(vehicleDataModel.getYear());
        existingVehicleData.setPrice(vehicleDataModel.getPrice());
        existingVehicleData.setPhoneNum(vehicleDataModel.getPhoneNum());
        // save existing employee to DB
        vehicleDataReporsitory.save(existingVehicleData);
        return existingVehicleData;
    }

    @Override
    public void deleteVehicleData(long id) {
        vehicleDataReporsitory.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Vehicle Data","Id",id));

        vehicleDataReporsitory.deleteById(id);
    }

    @Override
    public VehicleDataModel saveVehicleData(VehicleDataModel vehicleDataModel) {
        if (vehicleDataModel.getVehicleBrand() == null || vehicleDataModel.getVehicleBrand().isEmpty()) {
            throw new IllegalArgumentException("Vehicle brand cannot be null or empty.");
        }
        return vehicleDataReporsitory.save(vehicleDataModel);
    }
}
