package com.alev.csci323.assignment1.sorter;

import java.util.Arrays;
import java.util.Objects;

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

    public int sort() {
        int count = 0;
        for (int j = 1; j < size; ++j) {
            int i = j - 1;
            double key = getNode(j).data;
            Node currentNode = getNode(i);
            while (currentNode != null && (Double.compare(currentNode.data, key) > 0)) {
                count++;
                currentNode.next.data = currentNode.data;
                currentNode = currentNode.prev;
            }
            if (currentNode == null) {
                head.data = key;
            } else {
                currentNode.next.data = key;
            }
        }
        return count;
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
            this.data = Objects.requireNonNull(data);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
