package com.alev.sorter;

import java.util.List;

public abstract class Sorter<T extends Comparable<T>> {
    public final String SORTER_TYPE;

    protected List<T> array;

    public Sorter(String sorterType) {
        this.SORTER_TYPE = sorterType;
    }

    public Sorter(String sorterType, List<T> array) {
        this.SORTER_TYPE = sorterType;
    }

    public List<T> getArray() {
        return array;
    }

    public void setArray(List<T> array) {
        this.array = array;
    }

    abstract public int sort();

    public String getSorterType() {
        return SORTER_TYPE;
    }
}
