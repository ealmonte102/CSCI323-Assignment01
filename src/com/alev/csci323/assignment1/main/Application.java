package com.alev.csci323.assignment1.main;

import com.alev.csci323.assignment1.analysis.AnalysisSaver;
import com.alev.csci323.assignment1.analysis.Analyzer;
import com.alev.csci323.assignment1.file.SimpleCSVWriter;
import com.alev.csci323.assignment1.file.SimpleRetriever;
import com.alev.csci323.assignment1.file.SimpleSortedListWriter;
import com.alev.csci323.assignment1.provider.Part1SorterProvider;
import com.alev.csci323.assignment1.provider.Part2SorterProvider;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
public class Application {
    public static void main(String[] args) {
        Analyzer analyzer = new Analyzer(
                new Part1SorterProvider(),
                new SimpleRetriever("./numfiles/data1")
        );
        AnalysisSaver saver = new AnalysisSaver(
                new SimpleCSVWriter(),
                new SimpleSortedListWriter()
        );
        saver.addResults(analyzer.analyzeFiles());
        executeAnalysis(analyzer, saver, "1");
        analyzer.setFileRetriever(new SimpleRetriever("./numfiles/data2"));
        analyzer.setSorterProvider(new Part2SorterProvider());
        saver.addResults(analyzer.analyzeFiles());
        executeAnalysis(analyzer, saver, "2");
    }

    private static void executeAnalysis(Analyzer analyzer, AnalysisSaver
            saver, String partNumber) {
        Path rootPath = Paths.get("./analysis/part" + partNumber + "/");
        try {
            saver.save(rootPath.resolve("analysis" + partNumber + ".csv"),
                    rootPath.resolve("sortedfiles/"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
