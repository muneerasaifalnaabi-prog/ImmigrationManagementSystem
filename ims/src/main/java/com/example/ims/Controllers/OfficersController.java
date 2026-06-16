package com.example.ims.Controllers;

import com.example.ims.Entities.BorderControllerOfficer;
import com.example.ims.Entities.ImmigrationOfficer;
import com.example.ims.Services.OfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("officers")
public class OfficersController {

    @Autowired
    OfficerService officerService;

    @PostMapping()
    public ImmigrationOfficer addOfficers(@RequestBody ImmigrationOfficer officer){
        return officerService.saveOfficer(officer);
    }
    @PostMapping("/border")
    public ImmigrationOfficer addBorderOfficer(@RequestBody BorderControllerOfficer officer){
        return officerService.saveBorderOfficer(officer);
    }





}
