package com.example.sithum_car_sale_vehicle.controller;

import com.example.sithum_car_sale_vehicle.model.VehicleDataModel;
import com.example.sithum_car_sale_vehicle.service.VehicleDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/vehicles")
public class VehicleDataController {
    private final VehicleDataService vehicleDataService;

    public VehicleDataController(VehicleDataService vehicleDataService) {
        this.vehicleDataService = vehicleDataService;
    }

    // Upload vehicle data along with the image
    @PostMapping("/upload")
    public ResponseEntity<VehicleDataModel> uploadVehicleImage(
            @RequestParam("vehicleBrand") String vehicleBrand,
            @RequestParam("engineCap") String engineCap,
            @RequestParam("year") int year,
            @RequestParam("price") double price,
            @RequestParam("phoneNum") String phoneNum,
            @RequestParam("description") String description,
            @RequestParam("vehicleImg") MultipartFile vehicleImg) throws IOException {

        // Create a new VehicleDataModel instance and set its properties
        VehicleDataModel vehicleDataModel = new VehicleDataModel();
        vehicleDataModel.setVehicleBrand(vehicleBrand);
        vehicleDataModel.setEngineCap(engineCap);
        vehicleDataModel.setYear(year);
        vehicleDataModel.setPrice(price);
        vehicleDataModel.setPhoneNum(phoneNum);
        vehicleDataModel.setDescription(description);

        // Convert the image to a byte array and set it
        vehicleDataModel.setVehicleImg(vehicleImg.getBytes());

        // Save the vehicle data using the service
        VehicleDataModel savedVehicleData = vehicleDataService.saveVehicleData(vehicleDataModel);

        // Return a response with the saved data
        return new ResponseEntity<>(savedVehicleData, HttpStatus.CREATED);
    }

    // Get all vehicle data
    @GetMapping()
    public List<VehicleDataModel> getAllVehicleData() {
        return vehicleDataService.getAllVehicleData();
    }

    // Get vehicle data by ID
    @GetMapping("{id}")
    public ResponseEntity<VehicleDataModel> getVehicleDataById(@PathVariable("id") long id) {
        return new ResponseEntity<>(vehicleDataService.getVehicleDataById(id), HttpStatus.OK);
    }

    // Update vehicle data
    @PutMapping("{id}")
    public ResponseEntity<VehicleDataModel> updateVehicleData(@PathVariable("id") long id,
                                                              @RequestBody VehicleDataModel vehicleDataModel) {
        return new ResponseEntity<>(vehicleDataService.updateVehicleData(vehicleDataModel, id), HttpStatus.OK);
    }

    // Delete vehicle data
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteVehicleData(@PathVariable("id") long id) {
        vehicleDataService.deleteVehicleData(id);
        return new ResponseEntity<>("Vehicle data deleted successfully!", HttpStatus.OK);
    }

    // Get vehicle image by ID
    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getVehicleImage(@PathVariable("id") long id) {
        VehicleDataModel vehicleDataModel = vehicleDataService.getVehicleDataById(id);
        byte[] imageData = vehicleDataModel.getVehicleImg();
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageData);
    }
}
