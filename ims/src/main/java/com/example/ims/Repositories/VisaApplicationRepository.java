package com.example.ims.Repositories;

import com.example.ims.Entities.VisaApplications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisaApplicationRepository extends JpaRepository<VisaApplications,Long> {
}
