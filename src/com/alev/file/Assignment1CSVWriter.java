package com.alev.file;


import java.util.Objects;

public interface Assignment1CSVWriter {
    char COMMA = ',';

    void writeCSVFile(String name);

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
