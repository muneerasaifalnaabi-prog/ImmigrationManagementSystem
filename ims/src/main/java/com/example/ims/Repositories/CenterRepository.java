package com.example.ims.Repositories;

import com.example.ims.Entities.ImmigrationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CenterRepository extends JpaRepository<ImmigrationCenter, Long> {
    ImmigrationCenter findByName(String name);

    List<ImmigrationCenter> findByType(String type);

    List<ImmigrationCenter> findByLocationCountry(String locationCountry);

    @Query("SELECT c FROM ImmigrationCenter c WHERE c.id = :id")
    ImmigrationCenter getCenterById(@Param("id") Long id);


}
