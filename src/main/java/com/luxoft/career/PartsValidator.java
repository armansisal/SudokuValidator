package com.luxoft.career;

public class PartsValidator {
    private final String input;
    private final int[][] parsedResult = new int[9][9];

    public PartsValidator(String input){
        this.input = input.replaceAll("[^\\d,\\n]", "");
    }

    public Result parse(){
        String[] lines = input.split("\n");
        if(lines.length != 9){
            return Result.INVALID_INPUT;
        }
        for (int i=0; i<lines.length; i++){
            String[] parts = lines[i].split(",");
            if(parts.length != 9){
                return Result.INVALID_INPUT;
            }
            for(int j=0; j<lines.length; j++){
                int cursor = Integer.parseInt(parts[j]); //because of regex this must be a number.
                if(cursor < 1 || cursor > 9){
                    return Result.OUTBOUND;
                }
                parsedResult[i][j]=cursor;
            }
        }
        return Result.SUCCESS;
    }

    public Result validateAll(){
        Result result;
        for (int i=0; i<9; i++){
            result = validateColumn(i);
            if(result != Result.SUCCESS){
                return result;
            }
            result = validateRow(i);
            if(result != Result.SUCCESS){
                return result;
            }
            result = validateBox3x3(i);
            if(result != Result.SUCCESS){
                return result;
            }
        }
        return Result.SUCCESS;
    }

    public Result validateColumn(int columnNumber){
        final int[] columnContents = new int[9];
        for(int i=0; i<9; i++){
            columnContents[i] = parsedResult[i][columnNumber];
        }
        return validate(columnContents);
    }

    public Result validateRow(int rowNumber){
        final int[] rowContents = new int[9];
        for(int j=0; j<9; j++){
            rowContents[j] = parsedResult[rowNumber][j];
        }
        return validate(rowContents);
    }

    public Result validateBox3x3(int boxNumber){
        final int[] boxContents = new int[9];
        int lr = boxNumber%3; //left to right
        int ud = boxNumber/3; // up to down
        for (int i=0; i<9; i++){
            boxContents[i] = parsedResult[(ud*3)+i/3][(lr*3)+i%3];
        }
        return validate(boxContents);
    }

    private static Result validate(int[] contents){
        int[] checker = new int[]{0,0,0,0,0,0,0,0,0};
        if(contents.length != 9){
            return Result.INVALID_INPUT;
        }
        for (int content : contents){
            if(content < 1 || content > 9){
                return Result.OUTBOUND;
            }
            checker[content-1]++;
            if(checker[content-1] > 1){
                return Result.DUPLICATE;
            }
        }
        for (int check : checker){
            if(check < 1){
                return Result.MISSING;
            }
        }
        return Result.SUCCESS;
    }
}
