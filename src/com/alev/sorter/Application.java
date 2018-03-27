package com.alev.sorter;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        ArrayList<Sorter> sorters = new ArrayList<>();
        sorters.add(new InsertionSorter());
        sorters.add(new MergeSorter());
        sorters.add(new HeapSorter());
        sorters.add(new QuickSorter());
        NumberFileParser fileParser = new NumberFileParser();
        String filename;
        for (int i = 3; i < 15; ++i) {
            int fileSuffix = (int) Math.pow(2, i);
            filename = "numfiles/data1/Num" + fileSuffix + ".txt";
            fileParser.setFilename(filename);
            int[] array = {};
            try {
                array = fileParser.readFile();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            for (Sorter sorter : sorters) {
                sorter.setArray(array.clone());
                System.out.printf("Sort Type: %s%n" +
                        "Count: %d%n" +
                        "Array: %s%n", sorter.getSorterType(), sorter.sort(), Arrays.toString(sorter.getArray()));
            }
            System.out.println();
        }
    }
}
