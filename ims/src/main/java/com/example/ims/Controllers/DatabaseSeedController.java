package com.example.ims.Controllers;

import com.example.ims.Entities.*;
import com.example.ims.Repositories.ApplicantRepository;
import com.example.ims.Repositories.CenterRepository;
import com.example.ims.Repositories.OfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class DatabaseSeedController {
    @Autowired
    CenterRepository centerRepository;
    @Autowired
    OfficerRepository officerRepository;
    @Autowired
    ApplicantRepository applicantRepository;
    @PostMapping("/seed")
    public String seedDatabase() {
        // Centers
        ImmigrationCenter center1 = new ImmigrationCenter();
        center1.setName("Muscat Center");
        center1.setLocationCountry("Oman");
        center1.setType("Main");
        center1.setDailyCapacity(500);

        ImmigrationCenter center2 = new ImmigrationCenter();
        center2.setName("Salalah Center");
        center2.setLocationCountry("Oman");
        center2.setType("Border");
        center2.setDailyCapacity(300);

        centerRepository.save(center1);
        centerRepository.save(center2);

        // Officers
        ImmigrationOfficer officer1 = new ImmigrationOfficer();
        officer1.setFirstName("Ahmed");
        officer1.setLastName("Ali");
        officer1.setBadgeNumber("OF100");
        officer1.setRanks("Senior");
        officer1.setClearancelevel(5);
        officer1.setActive(true);
        officer1.setCenter(center1);

        ImmigrationOfficer officer2 = new ImmigrationOfficer();
        officer2.setFirstName("Sara");
        officer2.setLastName("Mohammed");
        officer2.setBadgeNumber("OF101");
        officer2.setRanks("Junior");
        officer2.setClearancelevel(2);
        officer2.setActive(true);
        officer2.setCenter(center1);

        BorderControllerOfficer borderOfficer = new BorderControllerOfficer();

        borderOfficer.setFirstName("Majid");
        borderOfficer.setLastName("Salim");
        borderOfficer.setBadgeNumber("BC200");
        borderOfficer.setRanks("Border");
        borderOfficer.setClearancelevel(4);
        borderOfficer.setActive(true);
        borderOfficer.setAssignedCheckpoint("Muscat Airport");
        borderOfficer.setK9UnitAssigned(true);
        borderOfficer.setCenter(center2);

        officerRepository.save(officer1);
        officerRepository.save(officer2);
        officerRepository.save(borderOfficer);

        // Applicants
        Applicant applicant1 = new Applicant();
        applicant1.setFirstName("Ali");
        applicant1.setLastName("Hassan");
        applicant1.setPassportNumber("OM123");
        applicant1.setNationality("Omani");
        applicant1.setCriminalRecord(false);

        Applicant applicant2 = new Applicant();
        applicant2.setFirstName("Noor");
        applicant2.setLastName("Saeed");
        applicant2.setPassportNumber("OM456");
        applicant2.setNationality("Emirati");
        applicant2.setCriminalRecord(true);

        Applicant applicant3 = new Applicant();
        applicant3.setFirstName("Fatma");
        applicant3.setLastName("Khalid");
        applicant3.setPassportNumber("OM789");
        applicant3.setNationality("Jordanian");
        applicant3.setCriminalRecord(false);

        AsylumSeeker asylumSeeker = new AsylumSeeker();
        asylumSeeker.setFirstName("Omar");
        asylumSeeker.setLastName("Nasser");
        asylumSeeker.setPassportNumber("SY111");
        asylumSeeker.setNationality("Syrian");
        asylumSeeker.setCriminalRecord(false);
        asylumSeeker.setCountryOfOrigin("Syria");
        asylumSeeker.setSponsorOrganization("UNHCR");

        applicantRepository.save(applicant1);
        applicantRepository.save(applicant2);
        applicantRepository.save(applicant3);
        applicantRepository.save(asylumSeeker);

        return "Database seeded successfully!";
    }
}
