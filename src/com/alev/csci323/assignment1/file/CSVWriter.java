package com.alev.csci323.assignment1.file;

import com.alev.csci323.assignment1.sorter.Sorter;

import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

public interface CSVWriter {
    char COMMA = ',';
    char NEWLINE = '\n';

    void addResult(String fileName, Assignment1Result result);

    void writeCSVFile(Writer pw) throws IOException;

    class Assignment1Result {
        final int resultCount;
        final Sorter.Type sorterType;
        final int[] sortedArray;

        public Assignment1Result(Sorter.Type sorterType, int resultCount, int[]
                sortedArray) {
            this.sorterType = Objects.requireNonNull(sorterType);
            this.sortedArray = Objects.requireNonNull(sortedArray);
            this.resultCount = resultCount;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(sorterType).append(": ").append(resultCount);
            return builder.toString();
        }
    }
}
