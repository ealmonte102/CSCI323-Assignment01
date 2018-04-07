package com.alev.csci323.assignment1.file;

import com.alev.csci323.assignment1.sorter.Sorter.Type;
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
                new CSVWriter.Assignment1Result(Type.BUCKET_SORT, 8, "done"));
        StringWriter actualWriter = new StringWriter();
        writer.writeCSVFile(actualWriter);
        Assert.assertEquals("File Name,Bucket Sort\nNum8.txt,8\n", actualWriter.getBuffer().toString());
    }

    @Test
    public void writeCSVFile_oneFileMultipleResults_properCSVFile() throws IOException {
        writer.addResult("Num8.txt",
                new CSVWriter.Assignment1Result(Type.BUCKET_SORT, 8, "done"));
        writer.addResult("Num8.txt",
                new CSVWriter.Assignment1Result(Type.INSERTION_SORT, 23, "done"));
        StringWriter actualWriter = new StringWriter();
        writer.writeCSVFile(actualWriter);
        Assert.assertEquals("File Name,Bucket Sort,Insertion Sort\nNum8.txt,8,23\n", actualWriter.getBuffer().toString());
    }

    @Test
    public void writeCSVFile_multipleFilesMultipleResults_properCSVFile() throws IOException {
        writer.addResult("Num8.txt",
                new CSVWriter.Assignment1Result(Type.BUCKET_SORT, 8, "done"));
        writer.addResult("Num8.txt",
                new CSVWriter.Assignment1Result(Type.INSERTION_SORT, 23, "done"));
        writer.addResult("Num16.txt",
                new CSVWriter.Assignment1Result(Type.BUCKET_SORT, 100, "done"));
        writer.addResult("Num16.txt",
                new CSVWriter.Assignment1Result(Type.INSERTION_SORT, 150, "done"));
        StringWriter actualWriter = new StringWriter();
        writer.writeCSVFile(actualWriter);
        Assert.assertEquals("File Name,Bucket Sort,Insertion Sort\nNum8.txt,8,23\nNum16.txt,100,150\n", actualWriter.getBuffer().toString());
    }
}