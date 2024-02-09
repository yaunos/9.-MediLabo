package com.preventDiabet.GatewayMicroservice.service;

import com.preventDiabet.GatewayMicroservice.beans.AssessmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssessmentDTOService {

    @Autowired
    public AssessmentService assessmentService;
    @Autowired
    private PatientBeanService patientBeanService;

    @Autowired
    private NoteBeanService noteBeanService;


    public AssessmentDTO createAssessmentDTOById (int patId) {

        AssessmentDTO assessmentDTO = new AssessmentDTO();
        assessmentDTO.setPatient(patientBeanService.getPatientById(patId));
        assessmentDTO.setNotes(noteBeanService.getNoteByPatient(patId));
        assessmentDTO.setAge(assessmentService.getPatientAge(assessmentDTO.getPatient()));
        assessmentDTO.setDiabetEvaluation(assessmentService.estimateRisksEvaluationOfPatient(assessmentDTO.getPatient()));

        return assessmentDTO;
    }

}

