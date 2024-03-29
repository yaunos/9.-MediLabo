package com.preventDiabet.PatientMicroservice.repository;

import com.preventDiabet.PatientMicroservice.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

// Use bean @Repository for Spring Service to autowire the repository
@Repository
// We use an interface here on an existing way of using data : MongoRepository
// We indicate here to MongoRepository which document will be used -> Patient
// And the type of the Id -> String

// We can now interact with the database

//public interface PatientRepository extends MongoRepository<Patient, String> {
public interface PatientRepository extends CrudRepository<Patient, String> {
    List<Patient> findAll();
    List<Patient> findByLastname(String lastname);

    List<Patient> findByLastnameAndFirstname(String lastname, String firstname);
    Patient findById(int id);

    void deleteById(Integer id);
}
