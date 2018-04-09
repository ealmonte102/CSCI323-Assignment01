package com.alev.csci323.assignment1.analysis;

import com.alev.csci323.assignment1.file.CSVWriter;
import com.alev.csci323.assignment1.file.FileRetriever;
import com.alev.csci323.assignment1.file.SimpleSortedListWriter;
import com.alev.csci323.assignment1.file.SortedListWriter;
import com.alev.csci323.assignment1.parse.NumberFileParser;
import com.alev.csci323.assignment1.provider.SorterProvider;
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
    private final SorterProvider sorterProvider;
    private final SortedListWriter sortedListWriter;

    public Analyzer(SorterProvider sorterProvider,
                    FileRetriever fileRetriever,
                    CSVWriter csvWriter,
                    SimpleSortedListWriter sortedListWriter) {
        this.fileRetriever = Objects.requireNonNull(fileRetriever);
        this.csvWriter = Objects.requireNonNull(csvWriter);
        this.sorterProvider = Objects.requireNonNull(sorterProvider);
        this.sortedListWriter = Objects.requireNonNull(sortedListWriter);
    }

    public void executeAnalysis(String anaylsisDirectory, String
            sortDirectoryName) {
        NumberFileParser parser = new NumberFileParser();
        File sortedDirectory = new File(sortDirectoryName);
        if (!sortedDirectory.exists()) {
            sortedDirectory.mkdirs();
        }
        try (PrintWriter analysisPw = new PrintWriter(new FileOutputStream(anaylsisDirectory))) {
            for (File file : fileRetriever.retrieveDataFiles()) {
                parser.setFile(file);
                for (Sorter sorter : sorterProvider.getSorters()) {
                    sorter.setArray(parser.getParsedArray());
                    csvWriter.addResult(file.getName(),
                            new CSVWriter.Assignment1Result(
                                    sorter.getSorterType(),
                                    sorter.sort(),
                                    Arrays.toString(sorter.getArray())
                            )
                    );
                    sortedListWriter.setList(sorter.getArray());
                    sortedListWriter.writeList(
                            new PrintWriter(new FileOutputStream(
                                    new File(sortDirectoryName, file.getName
                                            ()))));
                }
            }
            csvWriter.writeCSVFile(analysisPw);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
