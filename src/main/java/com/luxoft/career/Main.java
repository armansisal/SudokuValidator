package com.luxoft.career;

public class Main {
    public static void main(String[] args) {
        Result result;
        final String filename = (args != null && args.length > 0) ? args[0] : null;
        if(filename == null || filename.isBlank()) {
            result = Result.INVALID_INPUT;
        } else {
            String input = SudokuCsvReader.readFileToString(args[0]);
            PartsValidator partsValidator = new PartsValidator(input);
            result = partsValidator.parse();
            if (result == Result.SUCCESS) {
                result = partsValidator.validateAll();
            }
        }
        System.out.println("Result: " + result);
    }
}