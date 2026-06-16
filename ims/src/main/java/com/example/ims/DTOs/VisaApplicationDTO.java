package com.example.ims.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VisaApplicationDTO {
    private Long id;
    private String visaType;
    private String status;

}
