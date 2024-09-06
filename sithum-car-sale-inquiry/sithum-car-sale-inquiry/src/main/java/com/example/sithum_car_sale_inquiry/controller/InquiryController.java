package com.example.sithum_car_sale_inquiry.controller;

import com.example.sithum_car_sale_inquiry.model.InquiryModel;
import com.example.sithum_car_sale_inquiry.service.InquiryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/inquiries")
public class InquiryController {
    private InquiryService inquiryService;

    public InquiryController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }

    @PostMapping()
    public ResponseEntity<InquiryModel> saveInquiry(@RequestBody InquiryModel inquiryModel){
        return new ResponseEntity<InquiryModel>(inquiryService.saveInquiry(inquiryModel), HttpStatus.CREATED);
    }

    @GetMapping()
    public List<InquiryModel> getAllInquiry(){
        return inquiryService.getAllInquiry();
    }

    @GetMapping("{id}")
    public ResponseEntity<InquiryModel> getInquiryById(@PathVariable("id") long Id){
        return new ResponseEntity<InquiryModel>(inquiryService.getInquiryById(Id),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<InquiryModel> updateInquiry(@PathVariable("id") long Id,
                                                @RequestBody InquiryModel inquiryModel){
        return new ResponseEntity<InquiryModel>(inquiryService.updateInquiry(inquiryModel,Id),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteInquiry(@PathVariable("id") long id){
        inquiryService.deleteInquiry(id);
        return new ResponseEntity<String>("Inquiry deleted successfully!",HttpStatus.OK);
    }
}
