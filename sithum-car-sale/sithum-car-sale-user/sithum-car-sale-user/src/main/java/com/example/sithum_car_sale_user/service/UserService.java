package com.example.sithum_car_sale_user.service;

import com.example.sithum_car_sale_user.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel saveUser(UserModel userModel);
    List<UserModel> getAllUser();
    UserModel getUserById(long id);
    UserModel updateUser(UserModel userModel,long id);
    void deleteUser(long id);
}
