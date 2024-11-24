package com.teachmeckills.c32.hw.lesson_14.validator;

public class DocnumValidator {
    public static boolean isValid(String document) {

        if (document.length() != 15) {
            return false;
        }
        if (!document.matches("[a-zA-Z0-9]+")) {
            return false;
        }
        return document.startsWith("docnum");
    }
}

