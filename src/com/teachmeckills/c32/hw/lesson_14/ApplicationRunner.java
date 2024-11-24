package com.teachmeckills.c32.hw.lesson_14;


import com.teachmeckills.c32.hw.lesson_14.filehandler.FileProcessor;

import java.util.Scanner;

public class ApplicationRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к входному файлу: ");
        String inputFile = scanner.nextLine();

        FileProcessor.processFiles(inputFile);


    }
}
