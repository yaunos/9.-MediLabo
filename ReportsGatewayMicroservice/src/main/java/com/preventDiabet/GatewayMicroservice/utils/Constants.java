package com.preventDiabet.GatewayMicroservice.utils;

import java.io.DataInput;
import java.util.ArrayList;
import java.util.List;

public class Constants {

//    public static void main (String[] args) {
//        List<String> DiabetsKeyList = new ArrayList<String>();

    public static final List<String> DIABETES_KEY_LIST = new ArrayList<>();

    static {

        DIABETES_KEY_LIST.add("Microalbumine");
        DIABETES_KEY_LIST.add("Taille");
        DIABETES_KEY_LIST.add("Poids");
        DIABETES_KEY_LIST.add("Fumeur");
        DIABETES_KEY_LIST.add("Anormal");
        DIABETES_KEY_LIST.add("Cholestérol");
        DIABETES_KEY_LIST.add("Vertige");
        DIABETES_KEY_LIST.add("Rechute");
        DIABETES_KEY_LIST.add("Réaction");
        DIABETES_KEY_LIST.add("Anticorps");
    }
}
