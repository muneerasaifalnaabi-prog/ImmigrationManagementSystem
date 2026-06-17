package com.example.ims.Repositories;

import com.example.ims.Entities.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long> {
    List<Interview> findByOfficerIdAndInterviewDate(Long officerId, String interviewDate);
    List<Interview> findByApplicantIdAndStatus(Long applicantId, String status);
    @Query("select i from Interview i where i.officer.id = :officerId and i.interviewDate = :date")
    List<Interview> getOfficerSchedule(@Param("officerId") Long officerId, @Param("date") String date
    );



}
