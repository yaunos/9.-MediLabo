package com.preventDiabet.PatientMicroservice.controller;

import com.preventDiabet.PatientMicroservice.model.Patient;
import com.preventDiabet.PatientMicroservice.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

// import javax.validation.Valid;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;


@Controller
public class PatientWebController {

    @Autowired
    private PatientService patientService;



    @RequestMapping("/web/patient/list")
    public String listPatient(Model model) {
        List<Patient> listPatients = patientService.getAllPatients();
        model.addAttribute("listPatients", listPatients);
        return "patientList";
    }



    @GetMapping("/web/patient/add")
    public String addPatientForm(Patient patient) {
        return "patientAdd";
    }


    @PostMapping("/web/patient/validate")
    public String validate(@Valid @DateTimeFormat(pattern= "yyyy-MM-dd") Patient patient, BindingResult result, Model model) {
        //public String validate(Patient patient, BindingResult result, Model model) {
        // If no errors in data provided by user, save data and go back to 'list' page
        if (!result.hasErrors()) {
            try {
                patientService.addPatient(patient);
                List<Patient> listPatients = patientService.getAllPatients();
                model.addAttribute("listPatients", listPatients);
                return "redirect:/web/patient/list";
            } catch (Exception e) {
                // Log the exception for debugging
                e.printStackTrace();
            }

        }
        result.getAllErrors().forEach(error -> {
            System.err.println("Validation Error: " + error.getDefaultMessage());
        });

        // else stay on the current page
        return "patientAdd";
    }


    @GetMapping("/web/patient/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Patient patient = patientService.getPatientsById(id);
        //       .orElseThrow(() -> new IllegalArgumentException("Invalid Patient Id:" + id));
        model.addAttribute("patient", patient);
        return "patientUpdate";
    }


    @PostMapping("/web/patient/update/{id}")
    public String updatePatient(@PathVariable("id") Integer id, @Valid Patient patient, BindingResult result, Model model) {
        // If errors in data provided by user, stay on current page
        if (result.hasErrors()) {
            return "patientUpdate";
        }
        // If no error, save data into database and go back to 'List' page
        patient.setId(id);
        patientService.addPatient(patient);
        List<Patient> listPatients = patientService.getAllPatients();
        model.addAttribute("listPatients", listPatients);
        return "redirect:/web/patient/list";
    }



    @GetMapping("/web/patient/delete/{id}")
    public String deletePatient(@PathVariable("id") Integer id, Model model) {
        patientService.deletePatientById(id);
        return "redirect:/web/patient/list";
    }

}



