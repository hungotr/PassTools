package com.example.passtools.model;

import java.security.SecureRandom;
import java.util.Random;

public class PasswordGenerator {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";

    private static final String ALL_CHARACTERS = LOWERCASE + UPPERCASE + DIGITS + SPECIAL_CHARACTERS;

    private final Random random;
    private final int length;

    public PasswordGenerator(int length) {
        this.length = length;
        this.random = new SecureRandom();
    }

    public String generatePassword() {
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            password.append(ALL_CHARACTERS.charAt(random.nextInt(ALL_CHARACTERS.length())));
        }
        return password.toString();
    }

   // public static void main(String[] args) {
      //  PasswordGenerator passwordGenerator = new PasswordGenerator(10);
       // String generatedPassword = passwordGenerator.generatePassword();
      //  System.out.println("Generated Password: " + generatedPassword);
   // }

}