package com.example.ims.Entities;

import jakarta.persistence.Entity;

@Entity
public class BorderControllerOfficer  extends  ImmigrationOfficer{
    private String assignedCheckpoint;
    private  Boolean k9UnitAssigned;

}
