package com.example.ims.DTOs;

import com.example.ims.Entities.ImmigrationOfficer;
import com.example.ims.Entities.VisaApplications;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class VisaApplicationDTO {
    private Long id;
    private String visaType;
    private String status;

    public static VisaApplicationDTO convertToDTO(VisaApplications entity) {
        VisaApplicationDTO dto = new VisaApplicationDTO();
        dto.setId(entity.getId());
        dto.setVisaType(entity.getVisaType());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public static List<VisaApplicationDTO> convertToDTO(List<VisaApplications> entities) {

        List<VisaApplicationDTO> dtos = new ArrayList<>();
        for (VisaApplications entity : entities) {
            dtos.add(convertToDTO(entity));
        }
        return dtos;
    }
}



