package com.example.ims.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ImmigrationCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String locationCountry;
    private String type;
    private int dailyCapacity;
    @OneToMany
    private List<ImmigrationOfficer> officers;

}
