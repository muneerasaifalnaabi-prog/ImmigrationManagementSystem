package com.example.ims.Services;

import com.example.ims.Entities.ImmigrationCenter;
import com.example.ims.Entities.ImmigrationOfficer;
import com.example.ims.Exceptions.ImsException;
import com.example.ims.Repositories.CenterRepository;
import com.example.ims.Repositories.OfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficerService {
    @Autowired
    OfficerRepository officerRepository;
    @Autowired
    CenterRepository centerRepository;

    public ImmigrationOfficer promoteOfficer(Long officerId, String newRank, int newClearanceLevel) {
        ImmigrationOfficer officer = officerRepository.findById(officerId).orElseThrow(() -> ImsException.notFound("Officer not found"));
        if (newClearanceLevel < 1 || newClearanceLevel > 5) {
            throw ImsException.badRequest("Clearance level must be between 1 and 5");
        }
        officer.setRanks(newRank);
        officer.setClearancelevel(newClearanceLevel);

        return officerRepository.save(officer);

    }

    public ImmigrationOfficer transferOfficer(Long officerId, Long newCenterId) {
        ImmigrationOfficer officer = officerRepository.findById(officerId).orElseThrow(() -> ImsException.badRequest("Officer not found"));
        ImmigrationCenter center = centerRepository.findById(newCenterId).orElseThrow(() -> ImsException.notFound("Center not found"));

        officer.setCenter(center);
        return officerRepository.save(officer);

    }

    public List<ImmigrationOfficer> findOfficersByRank(String rank) {
        return officerRepository.findByRanks(rank);
    }

    public List<ImmigrationOfficer> findOfficersByRank(String rank, int minimumClearanceLevel) {
        if (minimumClearanceLevel < 1 || minimumClearanceLevel > 5) {
            throw ImsException.badRequest("Clearance level must be between 1 and 5");
        }
        return officerRepository.findOfficersByRankAndClearanceLevel(rank, minimumClearanceLevel);
    }

}
