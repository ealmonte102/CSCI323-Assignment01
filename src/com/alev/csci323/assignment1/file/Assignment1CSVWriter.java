package com.alev.csci323.assignment1.file;

import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

public interface Assignment1CSVWriter {
    char COMMA = ',';
    char NEWLINE = '\n';

    void writeCSVFile(Writer pw) throws IOException;

    class Assignment1Result {
        final int resultCount;
        final String sorterType;
        final String sortedArray;

        public Assignment1Result(String sorterType, int resultCount, String sortedArray) {
            this.sorterType = Objects.requireNonNull(sorterType);
            this.sortedArray = Objects.requireNonNull(sortedArray);
            this.resultCount = resultCount;
        }
    }
}
