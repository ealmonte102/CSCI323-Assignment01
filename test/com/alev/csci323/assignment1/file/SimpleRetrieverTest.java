package com.alev.csci323.assignment1.file;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertArrayEquals;

public class SimpleRetrieverTest {

    @Test
    public void retrieveDataFiles_filesExist_allFilesRetrieved() {
        SimpleRetriever retriever = new SimpleRetriever("./numfiles/data1/");
        File[] retrievedFiles = new File[0];
        retrievedFiles = retriever.retrieveDataFiles();
        String[] expectedFilePaths = new String[]{
                "./numfiles/data1/Num8.txt", "./numfiles/data1/Num16.txt", "./numfiles/data1/Num32.txt",
                "./numfiles/data1/Num64.txt", "./numfiles/data1/Num128.txt", "./numfiles/data1/Num256.txt",
                "./numfiles/data1/Num512.txt", "./numfiles/data1/Num1024.txt", "./numfiles/data1/Num2048.txt",
                "./numfiles/data1/Num4096.txt", "./numfiles/data1/Num8192.txt", "./numfiles/data1/Num16384.txt"};
        String[] actualFilePaths = new String[retrievedFiles.length];
        for (int i = 0; i < retrievedFiles.length; ++i) {
            actualFilePaths[i] = retrievedFiles[i].getPath();
        }
        assertArrayEquals(expectedFilePaths, actualFilePaths);
    }
}