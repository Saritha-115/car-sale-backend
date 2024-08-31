package com.example.sithum_car_sale.service.impl;

import com.example.sithum_car_sale.exception.ResourceNotFoundException;
import com.example.sithum_car_sale.model.UserModel;
import com.example.sithum_car_sale.model.VehicleDataModel;
import com.example.sithum_car_sale.reporsitory.UserReporsitory;
import com.example.sithum_car_sale.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserReporsitory userReporsitory;

    public UserServiceImpl(UserReporsitory userReporsitory) {
        this.userReporsitory = userReporsitory;
    }

    @Override
    public UserModel saveUser(UserModel userModel) {
        return userReporsitory.save(userModel);
    }

    @Override
    public List<UserModel> getAllUser() {
        return userReporsitory.findAll();
    }

    @Override
    public UserModel getUserById(long id) {
        return userReporsitory.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Vehicle Data","Id",id));
    }

    @Override
    public UserModel updateUser(UserModel userModel, long id) {
        UserModel existingUser = userReporsitory.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Vehicle Data","Id",id));

        existingUser.setEmail(userModel.getEmail());
        existingUser.setName(userModel.getName());
        existingUser.setPassword(userModel.getPassword());
        // save existing employee to DB
        userReporsitory.save(existingUser);
        return existingUser;
    }

    @Override
    public void deleteUser(long id) {
        userReporsitory.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Vehicle Data","Id",id));

        userReporsitory.deleteById(id);
    }
}
