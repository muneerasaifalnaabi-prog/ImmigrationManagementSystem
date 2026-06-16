package com.example.ims.Services;

import com.example.ims.Entities.ImmigrationCenter;
import com.example.ims.Exceptions.ImsException;
import com.example.ims.Repositories.CenterRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CenterService {
    @Autowired
    CenterRepository centerRepository;

    public ImmigrationCenter saveCenter(ImmigrationCenter center) {
        if (center == null) {
            throw ImsException.badRequest("Center data cannot be null");
        }
        if (center.getName() == null || center.getName().isBlank()) {
            throw ImsException.badRequest("Center name is required");
        }
        if (center.getLocationCountry().isBlank()) {
            throw ImsException.badRequest("Country is required");
        }

        return centerRepository.save(center);
    }

    public ImmigrationCenter getCenterById(Long id) {
        return centerRepository.findById(id).orElseThrow(() -> ImsException.notFound("Center not found"));
    }
}
