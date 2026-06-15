package com.example.ims.Entities;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass

abstract class Person {
    private String  firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String email;


}
