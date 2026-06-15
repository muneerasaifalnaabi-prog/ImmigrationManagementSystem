package com.example.ims.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Applicant extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String passportNumber;
    private String nationality;
    private Boolean criminalRecord;
    @OneToMany
    List<VisaApplications> visaApplications;
    @OneToMany
    List<Interview> interviews;

}
