package com.alev.sorter;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class NumberFileParserTests {
    private NumberFileParser parser;

    @Before
    public void setUp() {
        parser = new NumberFileParser();
    }

    @Test
    public void readFile_fileEndsWithNewLines_ArrayWithIntegersReturned() throws FileNotFoundException {
        parser.setFilename("data/Num8.txt");
        ArrayList<Integer> arrayList = parser.readFile();
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2, 8, 3, 1, 7, 6, 5, 4));
        assertEquals(true, arrayList.equals(expected));
    }
}
