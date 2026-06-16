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
    private String ranks;
    private Boolean active;
    private String centerName;

    public static ImmigrationOfficerDTO convertToDTO(ImmigrationOfficer entity) {
        ImmigrationOfficerDTO dto = new ImmigrationOfficerDTO();

        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setRanks(entity.getRanks());
        dto.setActive(entity.getActive());

        if (entity.getCenter() != null) {
            dto.setCenterName(entity.getCenter().getName());
        }
        return dto;
    }



}
