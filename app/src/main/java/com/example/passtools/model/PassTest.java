package com.example.passtools.model;

import android.app.Activity;

public class PassTest {
    String lowerCase = "abcdefghijklmonpqrstuvwxyz";
    String upperCase = "ABCDEFGHIJKLMOPQRSTUVWXYZ";
    String number = "1234567890";
    String special = "!@#$%^&*()_+";

    public PassTest(String lowerCaseB, String upperCaseB, String numberB, String specialB) {
        this.lowerCase = lowerCaseB;
        this.upperCase = upperCaseB;
        this.number = numberB;
        this.special = specialB;

    }

    public String passwordExam(String toTest, Activity testaroni) {

        // String passwordEvaluation = "";
        int passwrdScore = 0;

        Boolean passLowerCaseTest = false, passUpperCaseTest = false, passNumberTest = false, passSpecialTest = false;

        int lwrMatch = 0, upprMatch = 0, numMatch = 0, spclMatch = 0;

        for (int i = 0; i < toTest.length(); i++) {
            char tempChar = toTest.charAt(i);

            for (int j = 0; j < upperCase.length(); j++) {
                if (tempChar == lowerCase.charAt(j)) {
                    lwrMatch++;
                } else if (tempChar == upperCase.charAt(j)) {
                    upprMatch++;
                } else if (j < number.length() && tempChar == number.charAt(j)) {
                    numMatch++;
                } else if (j < special.length() && tempChar == special.charAt(j)) {
                    spclMatch++;
                }
            }

        }
        if (lwrMatch >= 2) {
            passLowerCaseTest = true;
            passwrdScore++;
            //passwordEvaluation.endsWith(", Has enough lowercase letters");

        }
        if (upprMatch >= 2) {
            passUpperCaseTest = true;
            passwrdScore++;
            // passwordEvaluation.endsWith(", Has enough uppercase letters");
        }
        if (numMatch >= 2) {
            passNumberTest = true;
            passwrdScore++;
            //passwordEvaluation.endsWith(", Has enough number characters");
        }
        if (spclMatch >= 2) {
            passSpecialTest = true;
            passwrdScore++;
            //passwordEvaluation.endsWith(", Has enough special characters");
        }

        switch (passwrdScore) {

            // Case
            case 1:
                return "Weak";



            // Case
            case 2:
                return "Moderate";


            // Case
            case 3:
                return "Strong";


            // Case
            case 4:

                return "VERY STRONG";


            default:
                return "INVALID PASSWORD TRY AGAIN!";


        }

    }
}
