package com.alev.sorter;

import java.util.Arrays;

public class BucketList {
    private Node head;
    private Node end;
    private int size = 0;

    public void insert(Double data) {
        Node nodeToAdd = new Node(data);
        if (end == null) {
            head = nodeToAdd;
        } else {
            end.next = nodeToAdd;
            nodeToAdd.prev = end;
        }
        end = nodeToAdd;
        ++size;
    }

    public double[] toArray() {
        double[] arrayToReturn = new double[size];
        int i = 0;
        Node current = head;
        while (current != null) {
            arrayToReturn[i++] = current.data;
            current = current.next;
        }
        return arrayToReturn;
    }

    public void sort() {
        for (int j = 1; j < size; ++j) {
            int i = j - 1;
            double key = getNode(j).data;
            Node currentNode = getNode(i);
            while (currentNode != null && (Double.compare(currentNode.data, key) > 0)) {
                currentNode.next.data = currentNode.data;
                currentNode = currentNode.prev;
            }
            if (currentNode == null) {
                head.data = key;
            } else {
                currentNode.next.data = key;
            }
        }
    }

    private Node getNode(int j) {
        Node nodeToReturn = head;
        while (j > 0) {
            nodeToReturn = nodeToReturn.next;
            j--;
        }
        return nodeToReturn;
    }

    private final static class Node {
        Node next;
        Node prev;

        double data;

        Node(Double data) {
            if (data == null) {
                throw new IllegalArgumentException("Data cannot be null");
            }
            this.data = data;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
