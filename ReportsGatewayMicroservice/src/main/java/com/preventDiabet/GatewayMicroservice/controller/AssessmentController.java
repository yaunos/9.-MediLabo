package com.preventDiabet.GatewayMicroservice.controller;

import com.preventDiabet.GatewayMicroservice.beans.PatientBean;
import com.preventDiabet.GatewayMicroservice.service.AssessmentService;
import com.preventDiabet.GatewayMicroservice.service.PatientBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;

    @Autowired
    private PatientBeanService patientBeanService;


    @GetMapping("/assess/{id}")
    public String getAssessmentById(@PathVariable(name = "id") int id) {

        PatientBean patient = patientBeanService.getPatientById(id) ;
        return assessmentService.assessmentOfDiabetStatement(patient);

    }

    @GetMapping("/assess")
    public List<String> getAssessmentByName(@RequestParam(name = "lastname") String lastname) {

        List<String> listAssess = new ArrayList<>();
        List<PatientBean> patients = patientBeanService.getPatientByLastname(lastname) ;

        for (PatientBean p : patients){
            listAssess.add(assessmentService.assessmentOfDiabetStatement(p));
        }

        return listAssess;

    }
}
