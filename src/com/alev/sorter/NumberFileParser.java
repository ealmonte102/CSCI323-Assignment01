package com.alev.sorter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NumberFileParser {
    private String filename;
    private BufferedReader reader;

    private List<Integer> parsedArray;

    public NumberFileParser() {
    }

    public List<Integer> readFile() throws FileNotFoundException {
        if (parsedArray == null) {
            ArrayList<Integer> tempArrayList = new ArrayList<>();
            reader = new BufferedReader(new FileReader(new File(filename)));
            String currentLine;
            try {
                while ((currentLine = reader.readLine()) != null) {
                    tempArrayList.add(Integer.parseInt(currentLine));
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
            parsedArray = tempArrayList;
        }
        return parsedArray;
    }

    public void setFilename(String filename) {
        this.filename = filename;
        this.parsedArray = null;
    }
}
