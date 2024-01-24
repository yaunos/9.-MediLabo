package com.preventDiabet.PatientMicroservice.controller;


import com.preventDiabet.PatientMicroservice.model.Patient;
import com.preventDiabet.PatientMicroservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patients")
    public List<Patient> getPatients() {
        List<Patient> listPatients = patientService.getAllPatients();
        return listPatients;
    }


    @GetMapping("/patient/{id}")
    public Patient getPatientById(@PathVariable(name="id") int id) {
        Patient PatientByItsId = patientService.getPatientsById(id);
        return PatientByItsId;
    }



    @GetMapping("/patient/lastname/{lastname}")
    public List<Patient> getPatientByLastname(@PathVariable(name="lastname") String lastname) {
        List<Patient> listPatientsByLastName = patientService.getPatientsByLastname(lastname);
        return listPatientsByLastName;
    }


    @PostMapping("/patient/add")
    public Patient postPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
        return patient;
    }


    @PutMapping("/patient")
    public Patient savePatient(@RequestBody Patient patient) {
        return patient;
    }


}
