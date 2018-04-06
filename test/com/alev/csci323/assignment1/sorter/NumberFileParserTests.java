package com.alev.csci323.assignment1.sorter;

import com.alev.csci323.assignment1.parse.NumberFileParser;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertArrayEquals;

public class NumberFileParserTests {
    private NumberFileParser parser;

    @Before
    public void setUp() {
        parser = new NumberFileParser();
    }

    @Test
    public void readFile_fileEndsWithNewLines_ArrayWithIntegersReturned() {
        parser.setFile(new File("numfiles/data1/Num8.txt"));
        int[] integerArray = parser.getParsedArray();
        int[] expected = {2, 8, 3, 1, 7, 6, 5, 4};
        assertArrayEquals(expected, integerArray);
    }
}
