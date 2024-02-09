package com.preventDiabet.GatewayMicroservice.service;

import com.preventDiabet.GatewayMicroservice.beans.PatientBean;
import com.preventDiabet.GatewayMicroservice.proxy.PatientProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientBeanService {

    @Autowired
    public PatientProxy patientProxy;


    /**
     * GET all Patients from database
     * @return List<PatientBean> list of all patients.
     */
    public List<PatientBean> getAllPatients(){
        return patientProxy.getPatients();
    }


    /**
     * GET a patient by Id from database, if exists
     * @param patientId the Id of the patient to find
     * @return PatientBean patient found if any.
     */
    public PatientBean getPatientById(int patientId) {
        return patientProxy.getPatientById(patientId);
    }


    /**
     * GET a patient by Lastname from database, if exists
     * @param surname of the patient to find
     * @return List<PatientBean> patient found if any.
     */
    public List<PatientBean> getPatientByLastname(String lastname) {
        return patientProxy.getPatientByLastname(lastname);
    }
}
