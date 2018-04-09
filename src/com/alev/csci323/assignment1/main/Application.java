package com.alev.csci323.assignment1.main;


import com.alev.csci323.assignment1.analysis.Analyzer;
import com.alev.csci323.assignment1.file.SimpleCSVWriter;
import com.alev.csci323.assignment1.file.SimpleRetriever;
import com.alev.csci323.assignment1.file.SimpleSortedListWriter;
import com.alev.csci323.assignment1.provider.Part1SorterProvider;
import com.alev.csci323.assignment1.provider.Part2SorterProvider;

public class Application {
    public static void main(String[] args) {
        Analyzer analyzer =
                new Analyzer(
                        new Part1SorterProvider(),
                        new SimpleRetriever("./numfiles/data1"),
                        new SimpleCSVWriter(),
                        new SimpleSortedListWriter());
        Analyzer analyzer2 =
                new Analyzer(
                        new Part2SorterProvider(),
                        new SimpleRetriever("./numfiles/data2"),
                        new SimpleCSVWriter(),
                        new SimpleSortedListWriter());
        analyzer.executeAnalysis("analysis1.csv", "./sorted_data/part1");
        analyzer2.executeAnalysis("analysis2.csv", "./sorted_data/part2");
    }
}
