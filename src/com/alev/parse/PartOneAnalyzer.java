package com.alev.parse;

import com.alev.file.Assignment1FileRetriever;
import com.alev.sorter.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Objects;

public class PartOneAnalyzer {
    private static final String ANALYZER_NAME = "part1analysis.txt";
    private Assignment1FileRetriever fileRetriever;

    private Sorter[] sorters = {
            new InsertionSorter(),
            new MergeSorter(),
            new HeapSorter(),
            new QuickSorter()};

    public PartOneAnalyzer(Assignment1FileRetriever fileRetriever) {
        this.fileRetriever = Objects.requireNonNull(fileRetriever);
    }

    public void executeAnalysis() {
        NumberFileParser parser = new NumberFileParser();
        try {
            for (File file : fileRetriever.retrieveDataFiles()) {
                parser.setFile(file);
                for (Sorter sorter : sorters) {
                    sorter.setArray(parser.getParsedArray());
                    System.out.printf("Sorter Type: %s%n", sorter.getSorterType());
                    System.out.printf("Count: %d%n", sorter.sort());
                    System.out.printf("Array: %s%n", Arrays.toString(sorter.getArray()));

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
