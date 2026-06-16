package com.example.ims.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InterviewDTO {
    private Long id;
    private String interviewDate;
    private String status;
    private String purpose;

}
