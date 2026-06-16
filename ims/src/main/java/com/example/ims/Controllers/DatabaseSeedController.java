package com.example.ims.Controllers;

import com.example.ims.Repositories.ApplicantRepository;
import com.example.ims.Repositories.CenterRepository;
import com.example.ims.Repositories.OfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class DatabaseSeedController {
    @Autowired
    CenterRepository centerRepository;
    @Autowired
    OfficerRepository officerRepository;
    @Autowired
    ApplicantRepository applicantRepository;


}
