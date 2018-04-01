package com.alev.sorter;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({CountingSorterTests.class,
        HeapSorterTests.class,
        InsertionSorterTests.class,
        MergeSorterTests.class,
        QuickSorterTests.class,
        RadixSorterTests.class})
public final class AllTestsSuite {
}
