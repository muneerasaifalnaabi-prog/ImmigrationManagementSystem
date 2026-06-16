package com.example.ims.Controllers;

import com.example.ims.DTOs.InterviewDTO;
import com.example.ims.Entities.Interview;
import com.example.ims.Services.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("interviews")
public class InterviewController {
    @Autowired
    InterviewService interviewService;

    @PostMapping("/schedule/{applicantId}/{officerId}")
    public ResponseEntity<InterviewDTO> scheduleInterview(@PathVariable Long applicantId, @PathVariable Long officerId, @RequestParam String date) {
        return ResponseEntity.ok(InterviewDTO.convertToDTO(interviewService.scheduleInterview(applicantId, officerId, date)));

    }
    @PutMapping("/{id}/complete")
    public ResponseEntity<InterviewDTO> completeInterview(@PathVariable Long id) {
        return ResponseEntity.ok(InterviewDTO.convertToDTO(interviewService.completeInterview(id)));
    }
    @PutMapping("/{id}/cancel")
    public ResponseEntity<InterviewDTO> cancelInterview(@PathVariable Long id) {
        return ResponseEntity.ok(InterviewDTO.convertToDTO(interviewService.cancelInterview(id)));
    }
    @GetMapping("/officer/{officerId}/date/{date}")
    public ResponseEntity<List<InterviewDTO>> getOfficerSchedule(@PathVariable Long officerId, @PathVariable String date) {
        return ResponseEntity.ok(interviewService.getOfficerSchedule(officerId, date));
    }

}
