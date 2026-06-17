package com.example.ims.Repositories;

import com.example.ims.Entities.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {

    List<Applicant> findByNationality(String nationality);

    Applicant findByPassportNumber(String passportNumber);


}
