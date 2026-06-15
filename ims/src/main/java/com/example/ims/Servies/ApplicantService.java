package com.example.ims.Servies;

import com.example.ims.Entities.Applicant;
import com.example.ims.Entities.Interview;
import com.example.ims.Repositories.ApplicantRepository;
import com.example.ims.Repositories.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {
    @Autowired
    ApplicantRepository applicantRepository;
    @Autowired
    InterviewRepository interviewRepository;

    public Applicant addApplicant(Applicant applicant) {
        if (applicant.getFirstName().isBlank()) {
            throw new RuntimeException("First name is required");
        }

        if (applicant.getLastName().isBlank()) {
            throw new RuntimeException("Last name is required");
        }

        if (applicant.getPassportNumber().isBlank()) {
            throw new RuntimeException("Passport number is required");
        }

        return applicantRepository.save(applicant);
    }

    public Applicant addApplicant(String firstName, String lastName, String passportNumber, String nationality) {
        if (firstName.isBlank()) {
            throw new RuntimeException("First name is required.");
        }
        if (lastName.isBlank()) {
            throw new RuntimeException("Last name is required.");
        }
        if (passportNumber.isBlank()) {
            throw new RuntimeException("Passport number is required.");
        }
        if (applicantRepository.findByPassportNumber(passportNumber).equals(passportNumber)) {
            throw new RuntimeException("An applicant with passport number '" + passportNumber + "' already exists.");

        }

        Applicant applicant = new Applicant();
        applicant.setFirstName(firstName);
        applicant.setLastName(lastName);
        applicant.setPassportNumber(passportNumber);
        applicant.setNationality(nationality);

        return applicantRepository.save(applicant);
    }

    public Applicant flagCriminalRecord(Long applicantId) {
        Applicant applicant = applicantRepository.findById(applicantId).orElseThrow(() -> new RuntimeException("Applicant not found with id: " + applicantId));

        applicant.setCriminalRecord(true);
        applicantRepository.save(applicant);
        List<Interview> scheduledInterviews = interviewRepository.findByApplicantIdAndStatus(applicantId, "SCHEDULED");

        if (!scheduledInterviews.isEmpty()) {
            for (Interview interview : scheduledInterviews) {
                interview.setStatus("CANCELLED");
                interviewRepository.save(interview);
            }
        }

        return applicant;
    }

}
