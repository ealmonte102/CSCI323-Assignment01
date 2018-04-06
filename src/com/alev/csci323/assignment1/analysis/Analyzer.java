package com.alev.csci323.assignment1.analysis;

import com.alev.csci323.assignment1.file.CSVWriter;
import com.alev.csci323.assignment1.file.FileRetriever;
import com.alev.csci323.assignment1.parse.NumberFileParser;
import com.alev.csci323.assignment1.sorter.Sorter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Objects;

public class Analyzer {
    private final FileRetriever fileRetriever;
    private final CSVWriter csvWriter;
    private final Sorter[] sorters;

    public Analyzer(Sorter[] sorters,
                    FileRetriever fileRetriever,
                    CSVWriter csvWriter) {
        this.fileRetriever = Objects.requireNonNull(fileRetriever);
        this.csvWriter = Objects.requireNonNull(csvWriter);
        this.sorters = Objects.requireNonNull(sorters);
    }

    public void executeAnalysis(String name) {
        NumberFileParser parser = new NumberFileParser();
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(name)))) {
            for (File file : fileRetriever.retrieveDataFiles()) {
                parser.setFile(file);
                for (Sorter sorter : sorters) {
                    sorter.setArray(parser.getParsedArray());
                    csvWriter.addResult(
                            file.getName(),
                            new CSVWriter.Assignment1Result(
                                    sorter.getSorterType(),
                                    sorter.sort(),
                                    Arrays.toString(sorter.getArray())
                            )
                    );
                }
            }
            csvWriter.writeCSVFile(pw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
