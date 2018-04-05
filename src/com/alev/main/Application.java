package com.alev.main;

import com.alev.file.SimplePart1Retriever;
import com.alev.parse.PartOneAnalyzer;

public class Application {
    public static void main(String[] args) {
        PartOneAnalyzer analyzer = new PartOneAnalyzer(
                new SimplePart1Retriever("./numfiles/data1/"));
        analyzer.executeAnalysis();
    }
}
