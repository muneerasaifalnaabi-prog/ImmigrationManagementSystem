package com.example.ims.DTOs;


import com.example.ims.Entities.Applicant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String passportNumber;
    private String nationality;
    private Boolean criminalRecord;

    public static ApplicantDTO  convertToDTO(Applicant entity){
        ApplicantDTO dto = new ApplicantDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setPassportNumber(entity.getPassportNumber());
        dto.setNationality(entity.getNationality());
        dto.setCriminalRecord(entity.getCriminalRecord());


    }
}

