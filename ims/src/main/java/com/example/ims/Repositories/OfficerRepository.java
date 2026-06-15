package com.example.ims.Repositories;

import com.example.ims.Entities.ImmigrationOfficer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficerRepository extends JpaRepository<ImmigrationOfficer, Long> {
    ImmigrationOfficer findByBadgeNumber(String badgeNumber);

    List<ImmigrationOfficer> findByRanks(String ranks);

    List<ImmigrationOfficer> findByActive(boolean active);
    List<ImmigrationOfficer> findByCenterId(Long centerId);

    @Query(" SELECT o FROM ImmigrationOfficer o WHERE o.ranks = :rank AND o.clearancelevel >= :minimumClearanceLevel")
    List<ImmigrationOfficer> findOfficersByRankAndClearanceLevel(@Param("rank") String rank, @Param("minimumClearanceLevel") int minimumClearanceLevel);
}


}
