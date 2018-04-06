package com.alev.file;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;

public class SimpleCSVWriterTest {
    public SimpleCSVWriter writer;

    @Before
    public void setUp() {
        writer = new SimpleCSVWriter();
    }

    @Test
    public void writeCSVFile_oneFileOneResult_properCSVFile() throws IOException {
        writer.addResult("Num8.txt",
                new Assignment1CSVWriter.Assignment1Result("Bucket Sort", 8, "done"));
        StringWriter actualWriter = new StringWriter();
        writer.writeCSVFile(actualWriter);
        Assert.assertEquals(",Bucket Sort\nNum8.txt,8\n", actualWriter.getBuffer().toString());
    }

    @Test
    public void writeCSVFile_oneFileMultipleResults_properCSVFile() throws IOException {
        writer.addResult("Num8.txt",
                new Assignment1CSVWriter.Assignment1Result("Bucket Sort", 8, "done"));
        writer.addResult("Num8.txt",
                new Assignment1CSVWriter.Assignment1Result("Insertion Sort", 23, "done"));
        StringWriter actualWriter = new StringWriter();
        writer.writeCSVFile(actualWriter);
        Assert.assertEquals(",Bucket Sort,Insertion Sort\nNum8.txt,8,23\n", actualWriter.getBuffer().toString());
    }

    @Test
    public void writeCSVFile_multipleFilesMultipleResults_properCSVFile() throws IOException {
        writer.addResult("Num8.txt",
                new Assignment1CSVWriter.Assignment1Result("Bucket Sort", 8, "done"));
        writer.addResult("Num8.txt",
                new Assignment1CSVWriter.Assignment1Result("Insertion Sort", 23, "done"));
        writer.addResult("Num16.txt",
                new Assignment1CSVWriter.Assignment1Result("Bucket Sort", 100, "done"));
        writer.addResult("Num16.txt",
                new Assignment1CSVWriter.Assignment1Result("Insertion Sort", 150, "done"));
        StringWriter actualWriter = new StringWriter();
        writer.writeCSVFile(actualWriter);
        Assert.assertEquals(",Bucket Sort,Insertion Sort\nNum8.txt,8,23\nNum16.txt,100,150\n", actualWriter.getBuffer().toString());
    }
}