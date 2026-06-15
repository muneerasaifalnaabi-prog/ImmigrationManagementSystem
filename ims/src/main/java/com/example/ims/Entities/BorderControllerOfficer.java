package com.example.ims.Entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorderControllerOfficer  extends  ImmigrationOfficer{
    private String assignedCheckpoint;
    private  Boolean k9UnitAssigned;

}
