package com.example.ims.DTOs;


import com.example.ims.Entities.ImmigrationOfficer;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ImmigrationOfficerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String badgeNumber;
    private String ranks;
    private Boolean active;

    public static  ImmigrationOfficerDTO convertToDTO(ImmigrationOfficer entity){
        ImmigrationOfficerDTO dto = new ImmigrationOfficerDTO();

    }


}
