package com.alev.sorter;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class HeapSorter<T extends Comparable<T>> extends Sorter<T> {
    public static final String TYPE = "Heap Sort";

    public HeapSorter() {
        super(TYPE);
    }

    public HeapSorter(List<T> array) {
        super(TYPE, array);
    }

    public int sort() {
        AtomicInteger counter = new AtomicInteger(0);
        maxHeapify();

        for (int i = array.size() - 1; i >= 0; --i) {
            T temp = array.get(i);
            array.set(i, array.get(0));
            array.set(0, temp);
            maxHeapifyHelper(0, i, counter);
        }

        return counter.get();
    }

    public void maxHeapify() {
        for (int i = array.size() / 2; i >= 0; --i) {
            maxHeapifyHelper(i, array.size(), new AtomicInteger(0));
        }
    }

    private void maxHeapifyHelper(int currentNode, int heapSize, AtomicInteger counter) {
        int largest = currentNode;
        int leftChild = largest * 2 + 1;
        int rightChild = largest * 2 + 2;
        if (leftChild < heapSize && array.get(leftChild).compareTo(array.get(largest)) > 0) {
            largest = leftChild;
        }
        if (rightChild < heapSize && array.get(rightChild).compareTo(array.get(largest)) > 0) {
            largest = rightChild;
        }
        if (largest != currentNode) {
            T temp = array.get(currentNode);
            array.set(currentNode, array.get(largest));
            array.set(largest, temp);
            counter.set(counter.get() + 1);
            maxHeapifyHelper(largest, heapSize, counter);
        }
    }
}
