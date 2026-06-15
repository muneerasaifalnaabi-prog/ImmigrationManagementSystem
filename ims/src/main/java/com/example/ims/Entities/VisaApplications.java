package com.example.ims.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class VisaApplications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
