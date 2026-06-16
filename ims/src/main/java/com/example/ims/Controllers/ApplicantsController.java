package com.example.ims.Controllers;

import com.example.ims.DTOs.ApplicantDTO;
import com.example.ims.Exceptions.ImsException;
import com.example.ims.Services.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("applicants")
public class ApplicantsController {
    @Autowired
    ApplicantService  applicantService;

    @PostMapping("/add")
    public ResponseEntity<ApplicantDTO> addApplicant(@RequestBody ApplicantDTO applicantDTO) {
        if (applicantDTO == null) {
            throw ImsException.badRequest("applicant is null");
        }
        return applicantService.saveApplicant(applicantDTO);
;
    }
}
