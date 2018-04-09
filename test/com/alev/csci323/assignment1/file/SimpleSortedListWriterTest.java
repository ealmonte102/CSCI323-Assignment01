package com.alev.csci323.assignment1.file;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

public class SimpleSortedListWriterTest {
    private SimpleSortedListWriter listWriter;

    @Test
    public void writeList_multipleIntegersToWriter_allIntegersWritten() throws IOException {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        StringWriter writer = new StringWriter();
        listWriter = new SimpleSortedListWriter(integers);
        listWriter.writeList(writer);
        Assert.assertEquals("1\n2\n3\n", writer.getBuffer().toString());
    }
}