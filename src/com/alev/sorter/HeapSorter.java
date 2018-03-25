package com.alev.sorter;

import java.util.concurrent.atomic.AtomicInteger;

public class HeapSorter extends Sorter {

    public HeapSorter() {
        super();
    }

    public HeapSorter(int[] array) {
        super(array);
    }

    public int sort() {
        AtomicInteger counter = new AtomicInteger(0);
        maxHeapify();

        for(int i = array.length - 1; i >= 0; --i) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            maxHeapifyHelper(0, i, counter);
        }

        return counter.get();
    }

    public void maxHeapify() {
        maxHeapifyHelper(0, array.length, new AtomicInteger(0));
    }

    private void maxHeapifyHelper(int currentNode, int heapSize, AtomicInteger counter) {
        int largest = currentNode;
        int leftChild = largest * 2 + 1;
        int rightChild = largest * 2 + 2;
        if(leftChild < heapSize && array[leftChild] > array[largest]) { largest = leftChild; }
        if(rightChild < heapSize && array[rightChild] > array[largest]) { largest = rightChild; }
        if(largest != currentNode) {
            int temp = array[currentNode];
            array[currentNode] = array[largest];
            array[largest] = temp;
            counter.set(counter.get() + 1);
            maxHeapifyHelper(largest, heapSize, counter);
        }
    }
}
