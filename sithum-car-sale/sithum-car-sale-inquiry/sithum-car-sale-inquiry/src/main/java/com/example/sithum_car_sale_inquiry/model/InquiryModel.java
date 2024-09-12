package com.example.sithum_car_sale_inquiry.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "inquiry_table")
public class InquiryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email")
    private String email;

    @Column(name = "subject")
    private String subject;

    @Column(name = "inquiry")
    private String inquiry;
}
