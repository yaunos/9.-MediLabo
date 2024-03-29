package com.preventDiabet.GatewayMicroservice.service;

import com.preventDiabet.GatewayMicroservice.beans.NoteBean;
import com.preventDiabet.GatewayMicroservice.beans.PatientBean;
import com.preventDiabet.GatewayMicroservice.utils.Constants;
import com.preventDiabet.GatewayMicroservice.utils.DiabetEvaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AssessmentService {

    @Autowired
    private PatientBeanService patientBeanService;
    @Autowired
    private NoteBeanService noteBeanService;
    public long getPatientAge(PatientBean patient){
        Date todaysDate = new Date();

        // validate inputs ...
        // DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        // int d1 = Integer.parseInt(formatter.format(patient.getDateOfBirth()));
        // int d2 = Integer.parseInt(formatter.format(todaysDate));
        /**
         *  Conversion pour obtenir un nombre d'années cohérent
         */

        long age = (long)((todaysDate.getTime() - patient.getDateOfBirth().getTime()) / (365.25*24*60*60*1000));
        return age;
    }

    /* Check if keyword is present in a note */
    public boolean isKeywordPresentInList (String keyword, List<String> notes){

        boolean keywordFound = false;
        for (String note : notes) {
            if (note.toLowerCase().contains(keyword.toLowerCase())) {
                keywordFound = true;
                break;
            }
        }
        return keywordFound;
    }

    /* If keyword is present the counter is incremented */
    public int countKeywordsInNotesForPatientById (int patientId){

        List<NoteBean> notesByPatId = noteBeanService.getNoteByPatient(patientId);
        List<String> NotesByPatIdString = noteBeanService.extractNotesStringfromNote(notesByPatId);

        int keywordCounter = 0;
 //       for (String keyword : Constants.KEYWORDS){
        for (String keyword : Constants.DIABETES_KEY_LIST) {
 //       for (List<String> DiabetsKeyList : Constants.){
            if (isKeywordPresentInList(keyword, NotesByPatIdString)){
                keywordCounter = keywordCounter + 1;
            }
        }
        return keywordCounter;
    }


    /* The risk is evaluated depending on keyword count, gender and age */

    public DiabetEvaluation estimateRisksEvaluationOfPatient (PatientBean patient) {
        DiabetEvaluation diabetEvaluation = DiabetEvaluation.NONE;

        /**
         *  The patient can be in one of Risk level
         */

        // int patientAge = getPatientAge(patient);
        long patientAge = getPatientAge(patient);
        String patientGender = patient.getGender();
        int keywordsCount = countKeywordsInNotesForPatientById(patient.getId());

        if (keywordsCount==0){
            diabetEvaluation = DiabetEvaluation.NONE;
        }
        // else if (patientAge > 30 && keywordsCount==2){
        else if (patientAge > 30 && (keywordsCount==2 || keywordsCount==3 || keywordsCount==4 || keywordsCount==5)) {
            diabetEvaluation = diabetEvaluation.BORDERLINE;
        }
        else if ((patientAge <=30 && patientGender.equals("M") && keywordsCount>=3 && keywordsCount<5)
                || (patientAge <=30 && patientGender.equals("F") && keywordsCount>=4 && keywordsCount<7)
                || (patientAge >30 && keywordsCount>=6 && keywordsCount<8)){
            diabetEvaluation = DiabetEvaluation.IN_DANGER;
        }
        else if ((patientAge <=30 && patientGender.equals("M") && keywordsCount>=5)
                || (patientAge <=30 && patientGender.equals("F") && keywordsCount>=7)
                || (patientAge >30 && keywordsCount>=8)){
            diabetEvaluation = DiabetEvaluation.EARLY_ONSET;
        }

        return diabetEvaluation;
    }


    public String assessmentOfDiabetStatement (PatientBean patient){

        // int patientAge = getPatientAge(patient);
        long patientAge = getPatientAge(patient);
        DiabetEvaluation diabetEvaluation = estimateRisksEvaluationOfPatient(patient);

        String assessment = "Patient: " + patient.getFirstname() + " " + patient.getLastname() + " (age " + patientAge  +") diabetes assessment is: " + diabetEvaluation.getLevelInString();
        return assessment;
    }

}
