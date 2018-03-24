import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SorterTest {
    Sorter sorter;

    @Before
    public void setUp() {
        this.sorter = new Sorter(null);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void setArray() {
        int[] a = { 1 };
        sorter.setArray(a);
        assertArrayEquals(a, sorter.getArray());
    }

    @Test
    public void insertionSort_ReverselySorted_SortedInAscendingOrder() {
        int[] a = {9, 8, 7, 6};
        sorter.setArray(a);
        sorter.insertionSort();
        assertArrayEquals(a, new int[]{6, 7, 8, 9});
    }

    @Test
    public void mergeSort() {
        int[] a = {9, 8, 1, 2 ,4, 10, 2};
        sorter.setArray(a);
        sorter.mergeSort(0, a.length - 1);
    }

    @Test
    public void heapSort() {
    }

    @Test
    public void quickSort() {
    }
}