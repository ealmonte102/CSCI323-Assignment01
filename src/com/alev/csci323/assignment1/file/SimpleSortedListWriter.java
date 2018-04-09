package com.alev.csci323.assignment1.file;

import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

public class SimpleSortedListWriter implements SortedListWriter {
    private int[] listToBeWritten;

    @Override
    public void writeList(Writer writer) throws IOException {
        for (Integer element : listToBeWritten) {
            writer.write(element.toString() + '\n');
        }
        writer.flush();
    }

    public int[] getList() {
        return listToBeWritten.clone();
    }

    public void setList(int[] listToBeWritten) {
        this.listToBeWritten = Objects.requireNonNull(listToBeWritten);
    }
}
