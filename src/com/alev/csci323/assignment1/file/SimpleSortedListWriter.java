package com.alev.csci323.assignment1.file;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Objects;

public class SimpleSortedListWriter implements SortedListWriter {
    private List<Integer> listToBeWritten;

    @Override
    public void writeList(Writer writer) throws IOException {
        for (Integer element : listToBeWritten) {
            writer.write(element.toString() + '\n');
        }
        writer.flush();
    }

    public List<Integer> getList() {
        return listToBeWritten;
    }

    public void setList(List<Integer> listToBeWritten) {
        this.listToBeWritten = Objects.requireNonNull(listToBeWritten);
    }
}
