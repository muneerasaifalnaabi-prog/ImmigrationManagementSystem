package com.example.ims.Entities;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
abstract class Person {
    private String  firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String email;


}
