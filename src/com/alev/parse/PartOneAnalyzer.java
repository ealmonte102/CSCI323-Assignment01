package com.alev.parse;

import com.alev.sorter.*;

import java.io.File;
import java.util.Arrays;

public class PartOneAnalyzer {
    private static final String ANALYZER_NAME = "part1analysis.txt";
    private static final int FILE_START_EXPONENT = 3;
    private static final int FILE_END_EXPONENT = 15;
    private static final int FILE_NUMBER_BASE = 2;
    private File directoryLocation;
    private Sorter[] sorters = {
            new InsertionSorter(),
            new MergeSorter(),
            new HeapSorter(),
            new QuickSorter()};

    public PartOneAnalyzer(String directoryLocation) {
        this.directoryLocation = new File(directoryLocation);
    }

    public void executeAnalysis() {
        NumberFileParser parser = new NumberFileParser();
        for (int i = FILE_START_EXPONENT; i < FILE_END_EXPONENT; ++i) {
            parser.setFile(new File(directoryLocation, NumberFileParser.calculateFileName(FILE_NUMBER_BASE, i)));
            for (Sorter sorter : sorters) {
                sorter.setArray(parser.getParsedArray());
                System.out.printf("Sorter Type: %s%n", sorter.getSorterType());
                System.out.printf("Count: %d%n", sorter.sort());
                System.out.printf("Array: %s%n", Arrays.toString(sorter.getArray()));

            }
        }
    }
}
