package com.example.ims.Controllers;

import com.example.ims.Entities.VisaApplications;
import com.example.ims.Services.VisaApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("visas")
public class VisaApplicationController {
    @Autowired
    VisaApplicationService visaApplicationService;

    @PostMapping("/submit/{applicantId}")
    public VisaApplications submitVisa(@PathVariable Long applicantId, @RequestParam String type){
        return visaApplicationService.submitApplication(applicantId, type);
    }



}
