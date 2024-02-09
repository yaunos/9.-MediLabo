package com.preventdiabet.DoctorsNotesMicroService.controller;

import com.preventdiabet.DoctorsNotesMicroService.model.Note;
import com.preventdiabet.DoctorsNotesMicroService.service.NoteService;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

@Controller
public class NoteWebController {
    @Autowired
    private NoteService noteService;

    @RequestMapping("/web/note/list")
    public String listNotes(Model model) {
        List<Note> listNotes = noteService.getAllNotes();
        model.addAttribute("listNotes", listNotes);
        return "noteList.html";
    }

    /* User story : historic view of the patient */

    @RequestMapping("/web/note/listByPatient/{patient}")
    public String listNotesByPatientName(@RequestParam("patient") String patient,Model model) {
        List<Note> listNotes = noteService.getNoteByPatientName(patient);
        model.addAttribute("listNotes", listNotes);
        return "noteList.html";
    }

    @GetMapping("/web/note/add")
    public String addNoteForm(Note note) {
        return "noteAdd";
    }

    @PostMapping("/web/note/validate")
    public String validate(@Valid @DateTimeFormat(pattern= "yyyy-MM-dd") Note note, BindingResult result, Model model) {
        // If there are no errors in data provided by user, save data and go back to 'list' page
        if (!result.hasErrors()) {
            try {
                note.setDate(new Date());
                noteService.addNote(note);
                List<Note> listNotes = noteService.getAllNotes();
                model.addAttribute("listNotes", listNotes);
                return "redirect:/web/note/list";
            } catch (Exception e) {
                // Log the exception for debugging
                e.printStackTrace();
            }
        }

        result.getAllErrors().forEach(error -> {
            System.err.println("Validation Error: " + error.getDefaultMessage());
        });

        // else stay on the current page
        return "noteAdd";
    }

    @GetMapping("/web/note/update/{id}")
    public String showUpdateForm(@PathVariable("id") String id, Model model) {
        Note note = noteService.getNoteById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Note Id:" + id));
        model.addAttribute("note", note);
        return "noteUpdate";
    }


    @PostMapping("/web/note/update/{id}")
    public String updateNote(@PathVariable("id") String id, @Valid Note note, BindingResult result, Model model) {
        // If there are errors in data provided by user, stay on current page
        if (result.hasErrors()) {
            return "noteUpdate";
        }
        // If no error, save data into database and go back to 'List' page
        note.setId(id);
        note.setDate(new Date());
        noteService.updateNote(note);
        List<Note> listNotes = noteService.getAllNotes();
        model.addAttribute("listNotes", listNotes);
        return "redirect:/web/note/list";
    }


    @GetMapping("/web/note/delete/{id}")
    public String deleteNote(@PathVariable("id") String id, Model model) {
        noteService.deleteNoteById(id);
        return "redirect:/web/note/list";
    }
}
