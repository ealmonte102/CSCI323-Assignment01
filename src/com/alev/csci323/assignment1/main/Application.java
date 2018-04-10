package com.alev.csci323.assignment1.main;


import com.alev.csci323.assignment1.analysis.Analyzer;
import com.alev.csci323.assignment1.file.CSVWriter;
import com.alev.csci323.assignment1.file.SimpleRetriever;
import com.alev.csci323.assignment1.provider.Part1SorterProvider;
import com.alev.csci323.assignment1.provider.Part2SorterProvider;

import java.util.ArrayList;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Analyzer analyzer =
                new Analyzer(new Part1SorterProvider(),
                        new SimpleRetriever("./numfiles/data1"));

        for (Map.Entry<String, ArrayList<CSVWriter.Assignment1Result>>
                resultArrayList : analyzer.analyzeFiles().entrySet()) {
            System.out.print(resultArrayList.getKey() + ": ");
            System.out.println(resultArrayList.getValue());
            System.out.println();
        }

        analyzer.setFileRetriever(new SimpleRetriever("./numfiles/data2"));
        analyzer.setSorterProvider(new Part2SorterProvider());

        System.out.println("Part 2\n");
        for (Map.Entry<String, ArrayList<CSVWriter.Assignment1Result>>
                resultArrayList : analyzer.analyzeFiles().entrySet()) {
            System.out.print(resultArrayList.getKey() + ": ");
            System.out.println(resultArrayList.getValue());
            System.out.println();
        }
    }
}
