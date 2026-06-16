package com.example.ims.DTOs;

import com.example.ims.Entities.VisaApplications;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VisaApplicationDTO {
    private Long id;
    private String visaType;
    private String status;

    public static VisaApplicationDTO convertToDTO(VisaApplications entity){
        VisaApplicationDTO dto = new VisaApplicationDTO();

    }


}
