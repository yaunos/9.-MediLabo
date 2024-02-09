package com.preventDiabet.GatewayMicroservice.beans;

import com.preventDiabet.GatewayMicroservice.utils.DiabetEvaluation;

import java.util.List;

public class AssessmentDTO {

    private PatientBean patient;
    private List<NoteBean> notes;
    private int age;
    private DiabetEvaluation diabetEvaluation;

    public PatientBean getPatient() {
        return patient;
    }

    public void setPatient(PatientBean patient) {
        this.patient = patient;
    }

    public List<NoteBean> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteBean> notes) {
        this.notes = notes;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public DiabetEvaluation getDiabetEvaluation() {
        return diabetEvaluation;
    }

    public void setDiabetEvaluation(DiabetEvaluation diabetEvaluation) {
        this.diabetEvaluation = diabetEvaluation;
    }
}
