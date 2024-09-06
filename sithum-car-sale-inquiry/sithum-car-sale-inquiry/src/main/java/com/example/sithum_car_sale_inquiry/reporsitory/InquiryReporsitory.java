package com.example.sithum_car_sale_inquiry.reporsitory;

import com.example.sithum_car_sale_inquiry.model.InquiryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryReporsitory extends JpaRepository<InquiryModel,Long> {
}
