package com.teachmeckills.c32.hw.lesson_14.validator;

public class InvaliddocValidator {
    public static String validate(String document) {

        if ((document.length() == 0)) {
            return "пусто";
        }
        if (document.length() != 15) {
            return "неправильная длина";
        }
        if (!document.matches("[a-zA-Z0-9]+")) {
            return "содержит недопустимые символы";
        }
        if (!document.startsWith("docnum") && !document.startsWith("contract")) {
            return "неправильная последовательность символов";
        }
        return null;
    }
}
