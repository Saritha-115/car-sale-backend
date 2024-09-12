package com.example.sithum_car_sale_inquiry.service;

import com.example.sithum_car_sale_inquiry.model.InquiryModel;

import java.util.List;

public interface InquiryService {
    InquiryModel saveInquiry(InquiryModel inquiryModel);
    List<InquiryModel> getAllInquiry();
    InquiryModel getInquiryById(long id);
    InquiryModel updateInquiry(InquiryModel inquiryModel,long id);
    void deleteInquiry(long id);
}
