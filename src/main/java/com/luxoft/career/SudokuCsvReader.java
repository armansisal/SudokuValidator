package com.luxoft.career;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SudokuCsvReader {
    public static String readFileToString(String fileNameWithPath) {
        StringBuilder str = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            String line;
            bufferedReader = new BufferedReader(new FileReader(fileNameWithPath));
            while ((line = bufferedReader.readLine()) != null) {
               str.append(line);
               str.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return str.toString();
    }
}
