package com.teachmeckills.c32.hw.lesson_14.filehandler;

import com.teachmeckills.c32.hw.lesson_14.validator.ContractValidator;
import com.teachmeckills.c32.hw.lesson_14.validator.DocnumValidator;
import com.teachmeckills.c32.hw.lesson_14.validator.InvaliddocValidator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {

    public static void processFiles(String inputFile) {
        String validDocnumFile = "C:/Users/user/IdeaProjects/TeachMeSkills_C32_HW_Lesson_14/resources/docnum.txt";
        String validContractFile = "C:/Users/user/IdeaProjects/TeachMeSkills_C32_HW_Lesson_14/resources/contract.txt";
        String invalidDocumentsFile = "C:/Users/user/IdeaProjects/TeachMeSkills_C32_HW_Lesson_14/resources/invaliddoc.txt";

        List<String> validDocnums = new ArrayList<>();
        List<String> validContracts = new ArrayList<>();
        List<String> invalidDocs = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            boolean isFileEmpty = true;

            while ((line = reader.readLine()) != null) {
                isFileEmpty = false;

                String validationResult = InvaliddocValidator.validate(line);
                if (validationResult == null) {
                    if (DocnumValidator.isValid(line)) {
                        validDocnums.add(line);
                    } else if (ContractValidator.isValid(line)) {
                        validContracts.add(line);
                    } else {
                        invalidDocs.add(line);
                    }
                } else {
                    invalidDocs.add(line + " - " + validationResult);
                }
            }

            if (isFileEmpty) {
                System.out.println("Ошибка: входной файл пустой.");
                return;
            }

            writeToFile(validDocnumFile, validDocnums);
            writeToFile(validContractFile, validContracts);
            writeToFile(invalidDocumentsFile, invalidDocs);

            System.out.println("Документы обработаны успешно.");
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: файл не найден - " + inputFile);
        } catch (IOException e) {
            System.out.println("Ошибка при обработке файла: " + e.getMessage());
        }
    }

    private static void writeToFile(String filePath, List<String> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + filePath);
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
