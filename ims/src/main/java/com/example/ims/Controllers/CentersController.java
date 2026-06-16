package com.example.ims.Controllers;

import com.example.ims.DTOs.CenterDTO;
import com.example.ims.Entities.ImmigrationCenter;
import com.example.ims.Services.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("centers")
public class CentersController {
    @Autowired
    CenterService centerService;

    @PostMapping("/add")
    public ResponseEntity<CenterDTO> addCenter(@RequestBody ImmigrationCenter center) {

        ImmigrationCenter savedCenter = centerService.saveCenter(center);

        return ResponseEntity.ok(CenterDTO.convertToDTO(savedCenter));
    }





}
