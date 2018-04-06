package com.alev.csci323.assignment1.sorter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class BucketListTest {
    BucketList bucketList;

    @Before
    public void setUp() {
        bucketList = new BucketList();
    }

    @Test
    public void testInsert_emptyList_insertOneDouble() {
        bucketList.insert(1.0);
        Assert.assertArrayEquals(new double[]{1.0}, bucketList.toArray(), .0000001);
    }

    @Test
    public void testInsert_emptyList_insertThreeDouble() {
        bucketList.insert(1.0);
        bucketList.insert(2.0);
        bucketList.insert(3.0);
        Assert.assertArrayEquals(new double[]{1.0, 2.0, 3.0}, bucketList.toArray(), .0000001);
    }

    @Test
    public void testToString_oneElement_stringContainsOneElement() {
        bucketList.insert(1.0);
        Assert.assertEquals("[1.0]", bucketList.toString());
    }

    @Test
    public void testToString_twoElement_stringContainsCommaSeperator() {
        bucketList.insert(1.0);
        bucketList.insert(2.0);
        Assert.assertEquals("[1.0, 2.0]", bucketList.toString());
    }

    @Test
    public void sort() {
        bucketList.insert(9.0);
        bucketList.insert(8.0);
        bucketList.insert(7.0);
        bucketList.insert(6.0);
        bucketList.sort();
        System.out.println(Arrays.toString(bucketList.toArray()));
        Assert.assertArrayEquals(new double[]{6, 7, 8, 9}, bucketList.toArray(), .0000001);
    }
}