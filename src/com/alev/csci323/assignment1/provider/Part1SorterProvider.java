package com.alev.csci323.assignment1.provider;

import com.alev.csci323.assignment1.sorter.*;

import java.util.Arrays;
import java.util.List;

public class Part1SorterProvider implements SorterProvider {
    @Override
    public List<Sorter> getSorters() {
        return Arrays.asList(new InsertionSorter(),
                new MergeSorter(),
                new HeapSorter(),
                new QuickSorter());
    }
}
