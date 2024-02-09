package com.preventDiabet.GatewayMicroservice.controller;

import com.preventDiabet.GatewayMicroservice.beans.AssessmentDTO;
import com.preventDiabet.GatewayMicroservice.service.AssessmentDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AssessmentWebController {
    @Autowired
    AssessmentDTOService assessmentDTOService;

    @RequestMapping("/web/assess/{id}")
    public String listPatient(@PathVariable("id") Integer id, Model model) {
        AssessmentDTO assessmentDTO = assessmentDTOService.createAssessmentDTOById(id);
        model.addAttribute("assessmentDTO", assessmentDTO);
        return "assessmentById";
    }

}