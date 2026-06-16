package com.example.ims.Controllers;

import com.example.ims.Services.VisaApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisaApplicationController {
    @Autowired
    VisaApplicationService visaApplicationService;


}
