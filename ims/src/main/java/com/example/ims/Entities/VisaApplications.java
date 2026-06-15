package com.example.ims.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisaApplications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Applicant applicant;
    @ManyToOne
    private ImmigrationOfficer handlingOfficer;
    private String visaType;
    private String status;
    private String officerNotes;

}
