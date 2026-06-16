package com.example.ims.Services;

import com.example.ims.Entities.Applicant;
import com.example.ims.Entities.VisaApplications;
import com.example.ims.Exceptions.ImsException;
import com.example.ims.Repositories.ApplicantRepository;
import com.example.ims.Repositories.OfficerRepository;
import com.example.ims.Repositories.VisaApplicationRepository;
import jakarta.validation.ValidationException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
