package com.example.ims.Services;

import com.example.ims.Entities.Applicant;
import com.example.ims.Entities.ImmigrationOfficer;
import com.example.ims.Entities.Interview;
import com.example.ims.Exceptions.ImsException;
import com.example.ims.Repositories.ApplicantRepository;
import com.example.ims.Repositories.CenterRepository;
import com.example.ims.Repositories.InterviewRepository;
import com.example.ims.Repositories.OfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewService {
    @Autowired
    InterviewRepository interviewRepository;
    @Autowired
    ApplicantRepository applicantRepository;
    @Autowired
    OfficerRepository officerRepository;

    public Interview scheduleInterview(Long applicantId, Long officerId, String date) {

        Applicant applicant = applicantRepository.findById(applicantId).orElseThrow(() -> ImsException.notFound("Applicant not found"));
        ImmigrationOfficer officer = officerRepository.findById(officerId).orElseThrow(() -> ImsException.notFound("Officer not found"));
        List<Interview> existingInterviews = interviewRepository.findByOfficerIdAndInterviewDate(officerId, date);
        if (!existingInterviews.isEmpty()) {
            throw ImsException.badRequest("Officer is double-booked!");
        }
        Interview interview = new Interview();
        interview.setApplicant(applicant);
        interview.setOfficer(officer);
        interview.setInterviewDate(date);
        return interviewRepository.save(interview);
    }
   public Interview completeInterview(Long interviewId){
        Interview interview=interviewRepository.findById(interviewId).orElseThrow(()->ImsException.notFound("Interview Not Found"));
        interview.setStatus("COMPLETED");
        interviewRepository.save(interview);

   }




}
