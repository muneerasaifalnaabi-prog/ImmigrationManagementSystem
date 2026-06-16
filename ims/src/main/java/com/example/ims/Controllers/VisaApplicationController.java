package com.example.ims.Controllers;

import com.example.ims.DTOs.VisaApplicationDTO;
import com.example.ims.Entities.VisaApplications;
import com.example.ims.Services.VisaApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("visas")
public class VisaApplicationController {
    @Autowired
    VisaApplicationService visaApplicationService;

    @PostMapping("/submit/{applicantId}")
    public VisaApplications submitVisa(@PathVariable Long applicantId, @RequestParam String type){
        return visaApplicationService.submitApplication(applicantId, type);
    }
    @PutMapping("/{visaId}/assign/{officerId}")
    public VisaApplications assignOfficer(@PathVariable Long visaId, @PathVariable Long officerId){
        return visaApplicationService.assignOfficer(visaId, officerId);
    }

    @PutMapping("/{visaId}/process")
    public VisaApplications processVisa(@PathVariable Long visaId, @RequestParam String status, @RequestParam String notes){
        return visaApplicationService.processVisa(visaId, status, notes);
    }
    @GetMapping("/applicant/{applicantId}")
    public ResponseEntity<List<VisaApplicationDTO>> getApplicantVisas(@PathVariable Long applicantId){

        return ResponseEntity.ok(VisaApplicationDTO.convertToDTO(visaApplicationService.getVisasByApplicant(applicantId)));
    }
    @GetMapping("/status/{status}")
    public ResponseEntity<List<VisaApplicationDTO>>getVisasByStatus(@PathVariable String status){

        return  ResponseEntity.ok(VisaApplicationDTO.convertToDTO(visaApplicationService.getVisasByStatus(status)));
    }
}
