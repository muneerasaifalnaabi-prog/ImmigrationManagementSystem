package com.example.ims.Controllers;

import com.example.ims.Services.OfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("officers")
public class OfficersController {

    @Autowired
    OfficerService officerService;




}
