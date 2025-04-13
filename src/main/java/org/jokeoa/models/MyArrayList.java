package org.jokeoa.models;

import org.jetbrains.annotations.NotNull;
import org.jokeoa.interfaces.ListIn;

import java.util.Iterator;

/**
 * A custom implementation of a dynamic array that supports generic types.
 * Provides methods for adding, removing, retrieving, and manipulating elements.
 *
 * @param <T> the type of elements stored in this list
 */
public class MyArrayList<T> implements ListIn<T> {

    private Object[] array; // Internal array to store elements
    private int size;       // Current number of elements in the list

    /**
     * Constructs an empty list with an initial capacity of 10.
     */
    public MyArrayList() {
        int DEFAULT_CAPACITY = 10;
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Adds an item to the end of the list.
     *
     * @param item the item to be added
     */
    public void add(T item) {
        if (size == array.length) {
            increaseCapacity();
        }
        array[size++] = item;
    }

    /**
     * Increases the capacity of the internal array by 50%.
     */
    private void increaseCapacity() {
        int newCapacity = array.length + (array.length >> 1);
        Object[] newArray = new Object[newCapacity];
        myArrayCopy(array, newArray, size);
        array = newArray;
    }

    /**
     * Copies elements from the source array to the destination array.
     *
     * @param source      the source array
     * @param destination the destination array
     * @param length      the number of elements to copy
     */
    private void myArrayCopy(Object[] source, Object[] destination, int length) {
        for (int i = 0; i < length; i++) {
            destination[i] = source[i];
        }
    }

    /**
     * Replaces the element at the specified index with the given item.
     *
     * @param index the index of the element to replace
     * @param item  the new item
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void set(int index, Object item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        array[index] = item;
    }

    /**
     * Inserts an item at the specified index, shifting subsequent elements to the right.
     *
     * @param index the index at which the item is to be inserted
     * @param item  the item to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void add(int index, Object item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (size == array.length) {
            increaseCapacity();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        size++;
    }

    /**
     * Adds an item to the beginning of the list.
     *
     * @param item the item to be added
     */
    public void addFirst(Object item) {
        if (size == array.length) {
            increaseCapacity();
        }
        for (int i = size; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = item;
        size++;
    }

    /**
     * Adds an item to the end of the list.
     *
     * @param item the item to be added
     */
    public void addLast(Object item) {
        if (size == array.length) {
            increaseCapacity();
        }
        array[size++] = item;
    }

    /**
     * Retrieves the element at the specified index.
     *
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) array[index];
    }

    /**
     * Retrieves the first element in the list.
     *
     * @return the first element
     */
    public T getFirst() {
        return (T) array[0];
    }

    /**
     * Retrieves the last element in the list.
     *
     * @return the last element
     */
    public T getLast() {
        return (T) array[size - 1];
    }

    /**
     * Removes the element at the specified index, shifting subsequent elements to the left.
     *
     * @param index the index of the element to remove
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null;
    }

    /**
     * Removes the first element in the list.
     *
     * @throws IndexOutOfBoundsException if the list is empty
     */
    @Override
    public void removeFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Size: " + size);
        }
        for (int i = 0; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null;
    }

    /**
     * Removes the last element in the list.
     *
     * @throws IndexOutOfBoundsException if the list is empty
     */
    public void removeLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Size: " + size);
        }
        array[--size] = null;
    }

    /**
     * Sorts the elements in the list in ascending order using the bubble sort algorithm.
     * Assumes that the elements implement the {@link Comparable} interface.
     */
    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (((Comparable<T>) array[j]).compareTo((T) array[j + 1]) > 0) {
                    Object temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Returns the index of the first occurrence of the specified object, or -1 if not found.
     *
     * @param object the object to search for
     * @return the index of the first occurrence, or -1 if not found
     */
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified object, or -1 if not found.
     *
     * @param object the object to search for
     * @return the index of the last occurrence, or -1 if not found
     */
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Checks if the specified object exists in the list.
     *
     * @param object the object to search for
     * @return true if the object exists, false otherwise
     */
    public boolean exists(Object object) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(object)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Converts the list to an array containing all its elements.
     *
     * @return an array containing all elements in the list
     */
    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[size];
        myArrayCopy(array, newArray, size);
        return newArray;
    }

    /**
     * Clears all elements from the list.
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over the elements in the list.
     *
     * @return an iterator for the list
     */
    @Override
    public @NotNull Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new IndexOutOfBoundsException("No more elements to iterate.");
                }
                return (T) array[currentIndex++];
            }
        };
    }
}
