package com.preventDiabet.PatientMicroservice.model;

// import javax.persistence.*;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

// @Entity

/**
 * data.mongoDB.coreMapping
 */
@Document(collection = "patients")

public class Patient {

    @Id
    /**
     * it seems MongoDB doesn't use same syntax for Ids like in SQL
     */
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Integer patientId;
    // private ObjectId patientId;

    private int id;
    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotBlank
    private String dateOfBirth;
    @NotBlank
    private String gender;
    private String address;
    private String phoneNumber;


    // getters and setters

    // public Integer getPatientId() {return patientId;}
    public int id() {return id;};

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    //public Date getDateOfBirth() {
    public @NotBlank String getDateOfBirth() {
        return dateOfBirth;
    }

    // public void setDateOfBirth(Date dateOfBirth) {
    public void setDateOfBirth(@NotBlank String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
