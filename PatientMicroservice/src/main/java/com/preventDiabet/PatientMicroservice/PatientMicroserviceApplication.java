package com.preventDiabet.PatientMicroservice;

import com.preventDiabet.PatientMicroservice.service.PatientService;
import com.preventDiabet.PatientMicroservice.utils.StringToDateConverter;
import com.preventDiabet.PatientMicroservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration // To be considered as a feign client
//@FeignClient(name = "patient-service")
public class PatientMicroserviceApplication {
// public class PatientMicroserviceApplication implements CommandLineRunner {
// public class PatientMicroserviceApplication extends SpringBootServletInitializer {
	@Bean
	public StringToDateConverter stringToDateConverter() {
		return new StringToDateConverter();
	}
	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private PatientService patientService;

	public static void main(String[] args) {
		SpringApplication.run(PatientMicroserviceApplication.class, args);
	}




}
