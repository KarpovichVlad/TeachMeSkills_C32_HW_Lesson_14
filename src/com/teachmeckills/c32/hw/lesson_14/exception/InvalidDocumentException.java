package com.teachmeckills.c32.hw.lesson_14.exception;

// Кастомное исключение для невалидных документов
public class InvalidDocumentException extends Exception {
    public InvalidDocumentException(String message) {
        super(message);
    }
}
