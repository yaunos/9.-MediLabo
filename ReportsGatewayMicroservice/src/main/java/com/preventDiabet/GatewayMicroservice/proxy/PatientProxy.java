package com.preventDiabet.GatewayMicroservice.proxy;

import com.preventDiabet.GatewayMicroservice.beans.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${feignPatient.name}", url = "${feignPatient.url}")
public interface PatientProxy {

    @GetMapping("/patients")
    List<PatientBean> getPatients();

    @GetMapping("/patient/{id}")
    PatientBean getPatientById(@PathVariable(name = "id") int patientId);

    @GetMapping("/patient")
    List<PatientBean> getPatientByLastname(@RequestParam(name = "lastname") String lastname);
}
