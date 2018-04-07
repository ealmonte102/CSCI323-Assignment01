package com.alev.csci323.assignment1.sorter;

public abstract class Sorter {
    public final Type SORTER_TYPE;

    protected int[] array;

    public Sorter(Type sorterType) {
        this.array = new int[0];
        this.SORTER_TYPE = sorterType;
    }

    public Sorter(Type sorterType, int[] array) {
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

    public Type getSorterType() {
        return SORTER_TYPE;
    }

    public enum Type {
        INSERTION_SORT,
        MERGE_SORT,
        HEAP_SORT,
        QUICK_SORT,
        COUNTING_SORT,
        RADIX_SORT,
        BUCKET_SORT;


        @Override
        public String toString() {
            String name = name();
            StringBuilder builder = new StringBuilder();
            boolean nextIsCaps = true;
            for (char c : name.toCharArray()) {
                if (c == '_') {
                    c = ' ';
                    nextIsCaps = true;
                } else if (nextIsCaps) {
                    nextIsCaps = false;
                    c = Character.toUpperCase(c);
                } else {
                    c = Character.toLowerCase(c);
                }
                builder.append(c);
            }
            return builder.toString();
        }
    }
}
