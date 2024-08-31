package com.example.sithum_car_sale.controller;

import com.example.sithum_car_sale.model.VehicleDataModel;
import com.example.sithum_car_sale.service.VehicleDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/vehicles")
public class VehicleDataController {
    private VehicleDataService vehicleDataService;

    public VehicleDataController(VehicleDataService vehicleDataService) {
        this.vehicleDataService = vehicleDataService;
    }

    @PostMapping()
    public ResponseEntity<VehicleDataModel> saveVehicleData(@RequestBody VehicleDataModel vehicleDataModel){
        return new ResponseEntity<VehicleDataModel>(vehicleDataService.saveVehicleData(vehicleDataModel), HttpStatus.CREATED);
    }

    @GetMapping()
    public List<VehicleDataModel> getVehicleDataById(){
        return vehicleDataService.getAllVehicleData();
    }

    // build get vehicle id REST api
    @GetMapping("{id}")
    public ResponseEntity<VehicleDataModel> getVehicleDataById(@PathVariable("id") long Id){
        return new ResponseEntity<VehicleDataModel>(vehicleDataService.getVehicleDataById(Id),HttpStatus.OK);
    }

    // build update vehicle REST api
    // http://localhost:8080/api/vehicles/1
    @PutMapping("{id}")
    public ResponseEntity<VehicleDataModel> updateVehicleData(@PathVariable("id") long Id,
                                                        @RequestBody VehicleDataModel employeeModel){
        return new ResponseEntity<VehicleDataModel>(vehicleDataService.updateVehicleData(employeeModel,Id),HttpStatus.OK);
    }

    // build delete vehicle REST api
    // http://localhost:8080/api/vehicles/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteVehicleData(@PathVariable("id") long id){
        vehicleDataService.deleteVehicleData(id);
        return new ResponseEntity<String>("Employee deleted successfully!",HttpStatus.OK);
    }
}
