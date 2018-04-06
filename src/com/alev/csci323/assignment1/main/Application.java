package com.alev.csci323.assignment1.main;


import com.alev.csci323.assignment1.analysis.Analyzer;
import com.alev.csci323.assignment1.file.SimpleCSVWriter;
import com.alev.csci323.assignment1.file.SimpleRetriever;
import com.alev.csci323.assignment1.sorter.*;

public class Application {
    public static void main(String[] args) {
        Sorter[] part1Sorters =
                new Sorter[]{
                        new InsertionSorter(),
                        new MergeSorter(),
                        new HeapSorter(),
                        new QuickSorter()
                };
        Sorter[] part2Sorters =
                new Sorter[]{
                        new CountingSorter(),
                        new RadixSorter(),
                        new BucketSorter()
                };
        Analyzer analyzer =
                new Analyzer(
                        part1Sorters,
                        new SimpleRetriever("./numfiles/data1"),
                        new SimpleCSVWriter()
                );
        Analyzer analyzer2 =
                new Analyzer(
                        part2Sorters,
                        new SimpleRetriever("./numfiles/data2"),
                        new SimpleCSVWriter()
                );
        analyzer.executeAnalysis("analysis1.csv");
        analyzer2.executeAnalysis("analysis2.csv");
    }
}
