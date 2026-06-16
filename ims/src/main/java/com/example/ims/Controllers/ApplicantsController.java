package com.example.ims.Controllers;

import com.example.ims.DTOs.ApplicantDTO;
import com.example.ims.Entities.Applicant;
import com.example.ims.Entities.AsylumSeeker;
import com.example.ims.Exceptions.ImsException;
import com.example.ims.Services.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("applicants")
public class ApplicantsController {
    @Autowired
    ApplicantService applicantService;

    @PostMapping()
    public Applicant addApplicant(@RequestBody Applicant applicant) {
        if (applicant == null) {
            throw ImsException.badRequest("applicant is null");
        }
        return applicantService.saveApplicant(applicant);
    }

    @PostMapping("asylum")
    public Applicant addAsylum(@RequestBody AsylumSeeker seeker) {
        if (seeker == null) {
            throw ImsException.badRequest("applicant is null");
        }
        return applicantService.saveApplicant(seeker);
    }

    @GetMapping()
    public ResponseEntity<List<ApplicantDTO>> getAllApplicants() {
        return ResponseEntity.ok(ApplicantDTO.convertToDTO(applicantService.getAllApplicant()));
    }

    @GetMapping("/search")
    public ResponseEntity<List<ApplicantDTO>> findByNationality(@RequestParam String nationality) {
        return ResponseEntity.ok(ApplicantDTO.convertToDTO(applicantService.findByNationality(nationality)));
    }

    @PutMapping("/{id}/flag")
    public ResponseEntity<ApplicantDTO> flagCriminalRecord(@PathVariable Long id) {
        Applicant applicant = applicantService.flagCriminalRecord(id);
        return ResponseEntity.ok(ApplicantDTO.convertToDTO(applicant));
    }


}
