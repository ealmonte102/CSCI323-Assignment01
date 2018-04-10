package com.alev.csci323.assignment1.file;

import com.alev.csci323.assignment1.sorter.Sorter.Type;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;

public class SimpleCSVWriterTest {
    private SimpleCSVWriter writer;
    private int[] emptyArray;

    @Before
    public void setUp() {
        writer = new SimpleCSVWriter();
        emptyArray = new int[]{};
    }

    @Test
    public void writeCSVFile_oneFileOneResult_properCSVFile() throws IOException {
        writer.addResult("Num8.txt",
                new CSVWriter.Assignment1Result(Type.BUCKET_SORT, 8,
                        emptyArray));
        StringWriter actualWriter = new StringWriter();
        writer.writeCSVFile(actualWriter);
        Assert.assertEquals("File Name,Bucket Sort\nNum8.txt,8\n", actualWriter.getBuffer().toString());
    }

    @Test
    public void writeCSVFile_oneFileMultipleResults_properCSVFile() throws IOException {
        writer.addResult("Num8.txt",
                new CSVWriter.Assignment1Result(Type.BUCKET_SORT, 8, emptyArray));
        writer.addResult("Num8.txt",
                new CSVWriter.Assignment1Result(Type.INSERTION_SORT, 23,
                        emptyArray));
        StringWriter actualWriter = new StringWriter();
        writer.writeCSVFile(actualWriter);
        Assert.assertEquals("File Name,Bucket Sort,Insertion Sort\nNum8.txt,8,23\n", actualWriter.getBuffer().toString());
    }

    @Test
    public void writeCSVFile_multipleFilesMultipleResults_properCSVFile() throws IOException {
        writer.addResult("Num8.txt",
                new CSVWriter.Assignment1Result(Type.BUCKET_SORT, 8, emptyArray));
        writer.addResult("Num8.txt",
                new CSVWriter.Assignment1Result(Type.INSERTION_SORT, 23, emptyArray));
        writer.addResult("Num16.txt",
                new CSVWriter.Assignment1Result(Type.BUCKET_SORT, 100, emptyArray));
        writer.addResult("Num16.txt",
                new CSVWriter.Assignment1Result(Type.INSERTION_SORT, 150, emptyArray));
        StringWriter actualWriter = new StringWriter();
        writer.writeCSVFile(actualWriter);
        Assert.assertEquals("File Name,Bucket Sort,Insertion Sort\nNum8.txt,8,23\nNum16.txt,100,150\n", actualWriter.getBuffer().toString());
    }
}