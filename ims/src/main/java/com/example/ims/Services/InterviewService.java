package com.example.ims.Services;

import com.example.ims.Repositories.ApplicantRepository;
import com.example.ims.Repositories.CenterRepository;
import com.example.ims.Repositories.InterviewRepository;
import com.example.ims.Repositories.OfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterviewService {
    @Autowired
    InterviewRepository interviewRepository;
    @Autowired
    ApplicantRepository applicantRepository;

    @Autowired
    OfficerRepository officerRepository



}
