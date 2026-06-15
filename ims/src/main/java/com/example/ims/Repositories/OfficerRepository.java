package com.example.ims.Repositories;

import com.example.ims.Entities.ImmigrationOfficer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficerRepository extends JpaRepository<ImmigrationOfficer, Long> {
    ImmigrationOfficer findByBadgeNumber(String badgeNumber);

    List<ImmigrationOfficer> findByRank(String rank);

    List<ImmigrationOfficer> findByActive(boolean active);

    List<ImmigrationOfficer> findByClearanceLevel(int clearanceLevel);

    List<ImmigrationOfficer> findByCenterId(Long centerId);
}
