package com.example.sithum_car_sale_user.reporsitory;

import com.example.sithum_car_sale_user.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReporsitory extends JpaRepository<UserModel,Long> {
}
