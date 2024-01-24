package com.preventDiabet.PatientMicroservice.service;

import com.preventDiabet.PatientMicroservice.model.Patient;
import com.preventDiabet.PatientMicroservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    /**
     *  READ PATIENT'S OR PATIENTS' INFORMATION
     */
    public List<Patient> getAllPatients() {

        return patientRepository.findAll();
    }

    public List<Patient> getPatientsByLastname(String lastname) {

        return patientRepository.findByLastname(lastname);
    }

    public List<Patient> getPatientsByLastnameAndFirstname(String lastname, String firstname) {
        return patientRepository.findByLastnameAndFirstname(lastname, firstname);
    }

    public Patient getPatientsById(int id) {
        return patientRepository.findById(id);
    }

    /**
     *  CREATE A PATIENT
     */

    public Patient addPatient(Patient patient) {
        patientRepository.save(patient);
        return patient;
    }


    /**
     *  UPDATE A PATIENT
     */

    public Patient updatePatient(Patient patient) {
        patientRepository.save(patient);
        return patient;
    }

    /**
     *  DELETE A PATIENT
     */

    public void deletePatientById(Integer id) {
        patientRepository.deleteById(id);
    }


}
