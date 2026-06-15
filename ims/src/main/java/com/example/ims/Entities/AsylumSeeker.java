package com.example.ims.Entities;

import jakarta.persistence.Entity;

@Entity
public class AsylumSeeker extends Applicant {
    private String countryOfOrigin;
    private String sponsorOrganization;
}
