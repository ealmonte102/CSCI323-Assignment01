package com.alev.analysis;

import com.alev.file.Assignment1CSVWriter;
import com.alev.file.Assignment1FileRetriever;
import com.alev.parse.NumberFileParser;
import com.alev.sorter.Sorter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Objects;

public class Assignment1Analyzer {
    private final Assignment1FileRetriever fileRetriever;
    private final Assignment1CSVWriter csvWriter;
    private final Sorter[] sorters;

    public Assignment1Analyzer(Sorter[] sorters, Assignment1FileRetriever fileRetriever, Assignment1CSVWriter csvWriter) {
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