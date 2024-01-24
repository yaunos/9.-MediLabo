package com.preventDiabet.PatientMicroservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@Entity
public class User
{
    @Id
    private String login;
    private String password;
}