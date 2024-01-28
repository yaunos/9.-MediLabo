package com.preventdiabet.DoctorsNotesMicroService.repository;

import com.preventdiabet.DoctorsNotesMicroService.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;


import org.springframework.stereotype.Repository;

import java.util.List;

// Use bean @Repository for Spring Service to autowire the repository
@Repository
// We use an interface here on an existing way of using data : MongoRepository
// We indicate here to MongoRepository which document will be used -> Patient
// And the type of the Id -> String

// We can now interact with the database

public interface NoteRepository extends MongoRepository<Note, String> {

    List<Note> findByPatId(int patientId);
    // List<Note> findByPatient(String patient);
    // List<Note> findNoteByPatient(String patient);

    List<Note> findByPatient(String patient);
}
