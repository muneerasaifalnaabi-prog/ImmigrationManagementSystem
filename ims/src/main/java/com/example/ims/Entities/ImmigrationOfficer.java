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
    private String ranks;
    private int clearancelevel;
    private Boolean active;
    @ManyToOne
   private ImmigrationCenter center;
    @OneToMany
   private List<Interview> interviews;


}
