package com.alev.csci323.assignment1.file;

import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class SimpleCSVWriter implements Assignment1CSVWriter {
    private final LinkedHashSet<String> COLUMN_NAMES = new LinkedHashSet<>();
    private final LinkedHashMap<String, LinkedHashSet<Assignment1Result>> analysisResults = new LinkedHashMap<>();

    public void addResult(String fileName, Assignment1Result result) {
        if (fileName == null || result == null) {
            return;
        }
        COLUMN_NAMES.add(result.sorterType);
        LinkedHashSet<Assignment1Result> resultList = analysisResults.get(fileName);
        if (resultList == null) {
            resultList = new LinkedHashSet<>();
            analysisResults.put(fileName, resultList);
        }
        resultList.add(result);
    }

    @Override
    public void writeCSVFile(Writer pw) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append(COMMA);

        for (String column : COLUMN_NAMES) {
            builder.append(column).append(COMMA);
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append(NEWLINE);

        for (Map.Entry<String, LinkedHashSet<Assignment1Result>> analysisEntry : analysisResults.entrySet()) {
            builder.append(analysisEntry.getKey()).append(COMMA);
            for (Assignment1Result result : analysisEntry.getValue()) {
                builder.append(result.resultCount).append(COMMA);
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.append(NEWLINE);
        }
        pw.append(builder.toString());
    }


}