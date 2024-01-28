package com.preventdiabet.DoctorsNotesMicroService;


import com.preventdiabet.DoctorsNotesMicroService.repository.NoteRepository;
import com.preventdiabet.DoctorsNotesMicroService.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
 public class DoctorsNotesMicroserviceApplication implements CommandLineRunner {
// public class DoctorsNotesMicroserviceApplication  {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private NoteService noteService;

    public static void main(String[] args) {
        SpringApplication.run(DoctorsNotesMicroserviceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

    }
}