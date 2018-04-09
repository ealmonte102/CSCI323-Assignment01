package com.alev.csci323.assignment1.file;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;

public class SimpleSortedListWriterTest {

    @Test
    public void writeList_multipleIntegersToWriter_allIntegersWritten()
            throws IOException {
        int[] integers = {1, 2, 3};
        StringWriter writer = new StringWriter();
        SimpleSortedListWriter listWriter = new SimpleSortedListWriter();
        listWriter.setList(integers);
        listWriter.writeList(writer);
        Assert.assertEquals("1\n2\n3\n", writer.getBuffer().toString());
    }
}