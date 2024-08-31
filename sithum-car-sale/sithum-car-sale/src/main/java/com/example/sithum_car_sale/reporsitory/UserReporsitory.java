package com.example.sithum_car_sale.reporsitory;

import com.example.sithum_car_sale.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReporsitory extends JpaRepository<UserModel,Long> {
}
