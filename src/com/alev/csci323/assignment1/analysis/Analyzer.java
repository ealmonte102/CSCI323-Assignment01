package com.alev.csci323.assignment1.analysis;

import com.alev.csci323.assignment1.file.FileRetriever;
import com.alev.csci323.assignment1.parse.NumberFileParser;
import com.alev.csci323.assignment1.provider.SorterProvider;
import com.alev.csci323.assignment1.sorter.Sorter;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import static com.alev.csci323.assignment1.file.CSVWriter.Assignment1Result;

public class Analyzer {
    private final NumberFileParser fileParser = new NumberFileParser();
    private SorterProvider sorterProvider;
    private FileRetriever fileRetriever;

    public Analyzer(SorterProvider sorterProvider,
                    FileRetriever fileRetriever) {
        this.fileRetriever = Objects.requireNonNull(fileRetriever);
        this.sorterProvider = Objects.requireNonNull(sorterProvider);
    }

    public Map<String, ArrayList<Assignment1Result>> analyzeFiles() {
        AnalyzerResultSet resultSet = new AnalyzerResultSet();
        for (File file : fileRetriever.retrieveDataFiles()) {
            fileParser.setFile(file);
            for (Sorter sorter : sorterProvider.getSorters()) {
                sorter.setArray(fileParser.getParsedArray());
                int count = sorter.sort();
                resultSet.addResultToFile(
                        file.getName(),
                        new Assignment1Result(sorter.getSorterType(),
                                count,
                                sorter.getArray())
                );
            }
        }
        return resultSet.getResults();
    }

    public void setSorterProvider(SorterProvider provider) {
        this.sorterProvider = Objects.requireNonNull(provider);
    }

    public void setFileRetriever(FileRetriever fileRetriever) {
        this.fileRetriever = fileRetriever;
    }

    private class AnalyzerResultSet {
        private Map<String, ArrayList<Assignment1Result>> results = new
                LinkedHashMap<>();

        void addResultToFile(String filename, Assignment1Result result) {
            ArrayList<Assignment1Result> resultsForFile = results.get(filename);
            if (resultsForFile == null) {
                resultsForFile = new ArrayList<>();
                results.put(filename, resultsForFile);
            }
            resultsForFile.add(result);
        }

        Map<String, ArrayList<Assignment1Result>> getResults() {
            return results;
        }
    }
}
