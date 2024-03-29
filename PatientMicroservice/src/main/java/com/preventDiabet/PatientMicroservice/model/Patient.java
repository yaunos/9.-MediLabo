package com.preventDiabet.PatientMicroservice.model;


// import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "patient")
/**
 * data.mongoDB.coreMapping
 */
// @Document(collection = "patients")

public class Patient {


    /**
     * it seems MongoDB doesn't use same syntax for Ids like in SQL
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // private ObjectId patientId;

    //private int id;
    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotBlank
    private Date dateOfBirth;
    @NotBlank
    private String gender;
    private String address;
    private String phoneNumber;


    // getters and setters

    // This syntax was an error with int : The error message was indicating that there was a NullPointerException when trying to invoke the intValue()
    // public int getId() {return id;};
    public Integer getId() {return id;}


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
    public @NotBlank Date getDateOfBirth() {
        return dateOfBirth;
    }

    // public void setDateOfBirth(Date dateOfBirth) {
    public void setDateOfBirth(@NotBlank Date dateOfBirth) {
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
