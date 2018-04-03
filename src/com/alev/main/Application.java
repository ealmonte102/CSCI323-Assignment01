package com.alev.main;

import com.alev.sorter.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        ArrayList<Sorter<Integer>> sorters = new ArrayList<>();
        sorters.add(new InsertionSorter<>());
        sorters.add(new MergeSorter<>());
        sorters.add(new HeapSorter<>());
        sorters.add(new QuickSorter<>());
        NumberFileParser fileParser = new NumberFileParser();
        String filename;
        for (int i = 3; i < 15; ++i) {
            int fileSuffix = (int) Math.pow(2, i);
            filename = "numfiles/data1/Num" + fileSuffix + ".txt";
            fileParser.setFilename(filename);
            List<Integer> array = new ArrayList<>();
            try {
                array = fileParser.readFile();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            for (Sorter<Integer> sorter : sorters) {
                sorter.setArray(new ArrayList<>(array));
                System.out.printf("Sort Type: %s%n" +
                        "Count: %d%n" +
                        "Array: %s%n", sorter.getSorterType(), sorter.sort(), sorter.getArray());
            }
            System.out.println();
        }
    }
}
