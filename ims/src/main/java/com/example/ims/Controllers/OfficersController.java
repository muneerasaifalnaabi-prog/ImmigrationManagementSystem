package com.example.ims.Controllers;

import com.example.ims.DTOs.ImmigrationOfficerDTO;
import com.example.ims.Entities.BorderControllerOfficer;
import com.example.ims.Entities.ImmigrationOfficer;
import com.example.ims.Services.OfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<ImmigrationOfficerDTO> getOfficerById(@PathVariable Long id){
        return ResponseEntity.ok(ImmigrationOfficerDTO.convertToDTO(officerService.getOfficerById(id)));
    }


}
