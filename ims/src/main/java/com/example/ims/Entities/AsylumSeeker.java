package com.example.ims.Entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AsylumSeeker extends Applicant {
    private String countryOfOrigin;
    private String sponsorOrganization;
}
