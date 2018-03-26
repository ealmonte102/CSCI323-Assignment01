package com.alev.sorter;

import java.io.*;
import java.util.ArrayList;

public class NumberFileParser {
    private String filename;
    private BufferedReader reader;

    private int[] parsedArray;

    public NumberFileParser() {

    }

    public NumberFileParser(String filename) {
        this.filename = filename;
    }

    public int[] readFile() throws FileNotFoundException {
        if(parsedArray == null) {
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
            parsedArray = new int[tempArrayList.size()];
            for (int i = 0; i < parsedArray.length; ++i) {
                parsedArray[i] = tempArrayList.get(i);
            }
        }
        return parsedArray;
    }

    public void setFilename(String filename) {
        this.filename = filename;
        this.parsedArray = null;
    }
}
