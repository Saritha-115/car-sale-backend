package com.example.sithum_car_sale.service;

import com.example.sithum_car_sale.model.UserModel;
import com.example.sithum_car_sale.model.VehicleDataModel;

import java.util.List;

public interface UserService {
    UserModel saveUser(UserModel userModel);
    List<UserModel> getAllUser();
    UserModel getUserById(long id);
    UserModel updateUser(UserModel userModel,long id);
    void deleteUser(long id);
}
