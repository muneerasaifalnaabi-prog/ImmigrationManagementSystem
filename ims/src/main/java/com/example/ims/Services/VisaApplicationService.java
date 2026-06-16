package com.example.ims.Services;

import com.example.ims.Entities.Applicant;
import com.example.ims.Entities.ImmigrationOfficer;
import com.example.ims.Entities.VisaApplications;
import com.example.ims.Exceptions.ImsException;
import com.example.ims.Repositories.ApplicantRepository;
import com.example.ims.Repositories.OfficerRepository;
import com.example.ims.Repositories.VisaApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisaApplicationService {
    @Autowired
    VisaApplicationRepository visaApplicationRepository;
    @Autowired
    ApplicantRepository applicantRepository;
    @Autowired
    OfficerRepository officerRepository;

    public VisaApplications submitApplication(Long applicantId, String visaType) {
        Applicant applicant = applicantRepository.findById(applicantId).orElseThrow(() -> ImsException.notFound("Applicant Not Found"));
        VisaApplications visa = new VisaApplications();

        visa.setApplicant(applicant);
        visa.setVisaType(visaType);

        if (applicant.getCriminalRecord() == true) {
            visa.setStatus("REJECTED");
            visa.setOfficerNotes("Auto-rejected due to criminal flag.");
        } else {
            visa.setStatus("PENDING");
        }
        return visaApplicationRepository.save(visa);
    }

    public VisaApplications assignOfficer(Long visaId, Long officerId) {
        VisaApplications visa = visaApplicationRepository.findById(visaId).orElseThrow(() -> ImsException.notFound("Visa Applicant not found "));

        ImmigrationOfficer officer = officerRepository.findById(officerId).orElseThrow(() -> ImsException.notFound("Officer not found "));

        List<VisaApplications> asylumVisas = visaApplicationRepository.findByApplicantIdAndVisaType(visa.getApplicant().getId(), "Asylum");

        if (!asylumVisas.isEmpty() && officer.getClearancelevel() < 4) {
            throw ImsException.badRequest("Asylum applications require clearance level 4 or 5");
        }

        visa.setHandlingOfficer(officer);

        return visaApplicationRepository.save(visa);


    }

    public VisaApplications processVisa(Long visaId, String newStatus, String notes) {

        VisaApplications visa = visaApplicationRepository.findById(visaId).orElseThrow(() -> ImsException.notFound("Visa application not found"));
        if (!newStatus.equalsIgnoreCase("APPROVED") && !newStatus.equalsIgnoreCase("REJECTED")) {
            throw ImsException.badRequest("Status must be APPROVED or REJECTED");
        }
        visa.setStatus(newStatus);
        visa.setOfficerNotes(notes);
        return visaApplicationRepository.save(visa);
    }


}
