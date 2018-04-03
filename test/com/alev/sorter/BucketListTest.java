package com.alev.sorter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
}