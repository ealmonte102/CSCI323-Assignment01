package com.alev.csci323.assignment1.sorter;

public abstract class Sorter {
    public final String SORTER_TYPE;

    protected int[] array;

    public Sorter(String sorterType) {
        this.array = new int[0];
        this.SORTER_TYPE = sorterType;
    }

    public Sorter(String sorterType, int[] array) {
        this.array = array;
        this.SORTER_TYPE = sorterType;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    abstract public int sort();

    public String getSorterType() {
        return SORTER_TYPE;
    }
}
