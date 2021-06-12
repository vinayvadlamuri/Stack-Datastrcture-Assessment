package com.bmw.assignment.stackdatastrctureassignment.impl;
import java.util.Arrays;

public class StackArrayAssignment <E>
{
    private int size = 0;
    private static final int INITIAL_CAPACITY = 1;
    public Object elements[];

    public StackArrayAssignment() {
        elements = new Object[INITIAL_CAPACITY];
    }

    public void push(E e) {
        if (size == elements.length) {
            checkCapacity();
        }
        elements[size++] = e;
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        E element = (E) elements[--size];
        elements[size] = null;
        return element;
    }

    private void checkCapacity() {
        int doubleSize = elements.length * 2;
        elements = Arrays.copyOf(elements, doubleSize);
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public int count() {
        return size;
    }

    @Override
    public String toString() {
        return "StackArrayAssignment{" + "size=" + size + ", elements=" + Arrays.toString(elements) + '}';
    }
}