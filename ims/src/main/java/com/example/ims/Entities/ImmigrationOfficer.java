package com.example.ims.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImmigrationOfficer extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String badgeNumber;
    private String rank;
    private int clearancelevel;
    private Boolean active;
    @ManyToAny
    Center center;
    @OneToMany
    List<Interview> interviews;



}
