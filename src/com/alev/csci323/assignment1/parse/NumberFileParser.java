package com.alev.csci323.assignment1.parse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class NumberFileParser {

    private File dataFile;
    private int[] parsedArray;

    public int[] getParsedArray() {
        if(parsedArray == null) {
            ArrayList<Integer> tempArrayList = parseFile();
            parsedArray = new int[tempArrayList.size()];
            for (int i = 0; i < parsedArray.length; ++i) {
                parsedArray[i] = tempArrayList.get(i);
            }
        }
        return parsedArray.clone();
    }

    public void setFile(File file) throws IllegalArgumentException {
        if (!file.isFile()) {
            throw new IllegalArgumentException("File provided is not a file");
        }
        dataFile = file;
        parsedArray = null;
    }

    private ArrayList<Integer> parseFile() {
        ArrayList<Integer> tempArrayList = new ArrayList<>();
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
                String currentLine;
                while ((currentLine = reader.readLine()) != null) {
                    tempArrayList.add(Integer.parseInt(currentLine));
                }
            } catch (NumberFormatException ignored) {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempArrayList;
    }

}
