package com.alev.sorter;

import java.io.*;
import java.util.ArrayList;

public class NumberFileParser {
    private String filename;
    private BufferedReader reader;
    private ArrayList<Integer> parsedArray;

    public NumberFileParser() {

    }

    public NumberFileParser(String filename) {
        this.filename = filename;
    }

    public ArrayList<Integer> readFile() throws FileNotFoundException {
        if(parsedArray == null) {
            parsedArray = new ArrayList<>();
            reader = new BufferedReader(new FileReader(new File(filename)));
            String currentLine;
            try {
                while ((currentLine = reader.readLine()) != null) {
                    parsedArray.add(Integer.parseInt(currentLine));
                }
            } catch (NumberFormatException ignored) {

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return parsedArray;
    }

    public void setFilename(String filename) {
        this.filename = filename;
        this.parsedArray = null;
    }
}
