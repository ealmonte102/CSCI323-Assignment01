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
        public final int resultCount;
        public final Sorter.Type sorterType;
        private final int[] sortedArray;

        public Assignment1Result(Sorter.Type sorterType, int resultCount, int[]
                sortedArray) {
            this.sorterType = Objects.requireNonNull(sorterType);
            this.sortedArray = Objects.requireNonNull(sortedArray.clone());
            this.resultCount = resultCount;
        }

        public int[] getSortedArray() {
            return sortedArray;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(sorterType).append(": ").append(resultCount);
            return builder.toString();
        }
    }
}
