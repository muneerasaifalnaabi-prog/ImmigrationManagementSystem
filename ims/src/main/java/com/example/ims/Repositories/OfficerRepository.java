package com.example.ims.Repositories;

import com.example.ims.Entities.ImmigrationOfficer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficerRepository extends JpaRepository<ImmigrationOfficer,Long> {
}
