package com.alev.csci323.assignment1.analysis;

import com.alev.csci323.assignment1.file.CSVWriter;
import com.alev.csci323.assignment1.file.FileRetriever;
import com.alev.csci323.assignment1.parse.NumberFileParser;
import com.alev.csci323.assignment1.sorter.Sorter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Objects;

public class Analyzer {
    private final FileRetriever fileRetriever;
    private final CSVWriter csvWriter;
    private final Sorter[] sorters;

    public Analyzer(Sorter[] sorters, FileRetriever fileRetriever, CSVWriter csvWriter) {
        this.fileRetriever = Objects.requireNonNull(fileRetriever);
        this.csvWriter = Objects.requireNonNull(csvWriter);
        this.sorters = Objects.requireNonNull(sorters);
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
