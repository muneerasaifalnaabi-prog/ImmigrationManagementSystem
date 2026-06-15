package com.example.ims.Repositories;

import com.example.ims.Entities.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long> {
    List<Interview> findByOfficerIdAndInterviewDate(Long officerId, String interviewDate);
    List<Interview> findByApplicantIdAndStatus(Long applicantId, String status);
    List<Interview> findByApplicantId(Long applicantId);
    List<Interview> findByOfficerId(Long officerId);



}
