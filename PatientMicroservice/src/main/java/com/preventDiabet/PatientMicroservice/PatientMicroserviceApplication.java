package com.preventDiabet.PatientMicroservice;

import com.preventDiabet.PatientMicroservice.utils.StringToDateConverter;
import com.preventDiabet.PatientMicroservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PatientMicroserviceApplication {

	@Bean
	public StringToDateConverter stringToDateConverter() {
		return new StringToDateConverter();
	}
	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(PatientMicroserviceApplication.class, args);
	}




}
