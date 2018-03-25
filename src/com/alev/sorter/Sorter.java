package com.alev.sorter;

public abstract class Sorter {
    protected int[] array;

    public Sorter() {
        this.array = new int[0];
    }

    public Sorter(int[] array) {
        this.array = array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }
}
