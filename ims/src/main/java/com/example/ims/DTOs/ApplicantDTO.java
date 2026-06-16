package com.example.ims.DTOs;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApplicantDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String passportNumber;
    private String nationality;
    private Boolean criminalRecord;
}
