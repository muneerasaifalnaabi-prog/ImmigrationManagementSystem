package com.example.ims.Controllers;

import com.example.ims.Entities.Interview;
import com.example.ims.Services.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("interviews")
public class InterviewController {
    @Autowired
    InterviewService interviewService;

    @PostMapping("/schedule/{applicantId}/{officerId}")
    public ResponseEntity<Interview> scheduleInterview(@PathVariable Long applicantId, @PathVariable Long officerId, @RequestParam String date) {

        return ResponseEntity.ok(interviewService.scheduleInterview(applicantId, officerId, date));

    }
}
