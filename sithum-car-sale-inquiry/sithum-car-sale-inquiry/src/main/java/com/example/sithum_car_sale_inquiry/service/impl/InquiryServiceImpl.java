package com.example.sithum_car_sale_inquiry.service.impl;

import com.example.sithum_car_sale_inquiry.exception.ResouceNotFoundException;
import com.example.sithum_car_sale_inquiry.model.InquiryModel;
import com.example.sithum_car_sale_inquiry.reporsitory.InquiryReporsitory;
import com.example.sithum_car_sale_inquiry.service.InquiryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InquiryServiceImpl implements InquiryService {
    private InquiryReporsitory inquiryReporsitory;

    public InquiryServiceImpl(InquiryReporsitory inquiryReporsitory) {
        this.inquiryReporsitory = inquiryReporsitory;
    }

    @Override
    public InquiryModel saveInquiry(InquiryModel inquiryModel) {
        return inquiryReporsitory.save(inquiryModel);
    }

    @Override
    public List<InquiryModel> getAllInquiry() {
        return inquiryReporsitory.findAll();
    }

    @Override
    public InquiryModel getInquiryById(long id) {
        return inquiryReporsitory.findById(id).orElseThrow(() ->
                new ResouceNotFoundException("Inquiry data","Id",id));
    }

    @Override
    public InquiryModel updateInquiry(InquiryModel inquiryModel, long id) {
        InquiryModel existingInquiry = inquiryReporsitory.findById(id).orElseThrow(()->
                new ResouceNotFoundException("Inquiry data","Id",id));
        existingInquiry.setEmail(inquiryModel.getEmail());
        existingInquiry.setInquiry(inquiryModel.getInquiry());
        inquiryReporsitory.save(existingInquiry);
        //save existing inquiry to DB
        return existingInquiry;
    }

    @Override
    public void deleteInquiry(long id) {
        inquiryReporsitory.findById(id).orElseThrow(()->
                new ResouceNotFoundException("Inquiry data","Id",id));

        inquiryReporsitory.deleteById(id);
    }
}
