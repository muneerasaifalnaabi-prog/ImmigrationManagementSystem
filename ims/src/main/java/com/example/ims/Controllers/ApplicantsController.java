package com.example.ims.Controllers;

import com.example.ims.Services.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("applicants")
public class ApplicantsController {
    @Autowired
    ApplicantService  applicantService;
}
