package com.alev.csci323.assignment1.provider;

import com.alev.csci323.assignment1.sorter.BucketSorter;
import com.alev.csci323.assignment1.sorter.CountingSorter;
import com.alev.csci323.assignment1.sorter.RadixSorter;
import com.alev.csci323.assignment1.sorter.Sorter;

import java.util.Arrays;
import java.util.List;

public final class Part2SorterProvider implements SorterProvider {
    @Override
    public List<Sorter> getSorters() {
        return Arrays.asList(
                new CountingSorter(),
                new RadixSorter(),
                new BucketSorter());
    }

}
