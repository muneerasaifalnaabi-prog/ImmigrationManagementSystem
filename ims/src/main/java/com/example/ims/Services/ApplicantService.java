package com.example.ims.Services;

import com.example.ims.Entities.Applicant;
import com.example.ims.Entities.Interview;
import com.example.ims.Exceptions.ImsException;
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

    public Applicant saveApplicant(Applicant applicant) {
        if (applicant.getFirstName().isBlank()) {
            throw ImsException.badRequest("First name is required");

        }

        if (applicant.getLastName().isBlank()) {
            throw  ImsException.badRequest("Last name is required");
        }

        if (applicant.getPassportNumber().isBlank()) {
            throw ImsException.badRequest("Passport number is required");
        }

        return applicantRepository.save(applicant);
    }

    public Applicant saveApplicant(String firstName, String lastName, String passportNumber, String nationality) {
        if (firstName.isBlank()) {
            throw ImsException.badRequest("First name is required.");
        }
        if (lastName.isBlank()) {
            throw ImsException.badRequest("Last name is required.");
        }
        if (passportNumber.isBlank()) {
            throw ImsException.badRequest("Passport number is required.");
        }
        if (applicantRepository.findByPassportNumber(passportNumber).equals(passportNumber)) {
            throw ImsException.badRequest("An applicant with passport number '" + passportNumber + "' already exists.");

        }

        Applicant applicant = new Applicant();
        applicant.setFirstName(firstName);
        applicant.setLastName(lastName);
        applicant.setPassportNumber(passportNumber);
        applicant.setNationality(nationality);

        return applicantRepository.save(applicant);
    }

    public Applicant flagCriminalRecord(Long applicantId) {
        Applicant applicant = applicantRepository.findById(applicantId).orElseThrow(() -> ImsException.notFound("Applicant not found with id"));

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
