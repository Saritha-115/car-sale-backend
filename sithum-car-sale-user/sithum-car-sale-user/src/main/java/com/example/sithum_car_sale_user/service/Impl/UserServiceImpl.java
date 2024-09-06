package com.example.sithum_car_sale_user.service.Impl;

import com.example.sithum_car_sale_user.exception.ResourceNotFoundException;
import com.example.sithum_car_sale_user.model.UserModel;
import com.example.sithum_car_sale_user.reporsitory.UserReporsitory;
import com.example.sithum_car_sale_user.service.UserService;
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
