package com.example.ims.DTOs;

import com.example.ims.Entities.Interview;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InterviewDTO {
    private Long id;
    private String interviewDate;
    private String status;
    private String purpose;

    public static InterviewDTO convertToDTO(Interview entity) {

        InterviewDTO dto = new InterviewDTO();

        dto.setId(entity.getId());
        dto.setInterviewDate(entity.getInterviewDate());
        dto.setStatus(entity.getStatus());
        dto.setPurpose(entity.getPurpose());
        return dto;
    }

}
