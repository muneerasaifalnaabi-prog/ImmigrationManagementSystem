package com.example.ims.Repositories;

import com.example.ims.Entities.VisaApplications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisaApplicationRepository extends JpaRepository<VisaApplications, Long> {
    List<VisaApplications> findByApplicantId(Long applicantId);
    List<VisaApplications> findByStatus(String status);
    List<VisaApplications> findByApplicantIdAndVisaType(Long applicantId, String visaType);
}
