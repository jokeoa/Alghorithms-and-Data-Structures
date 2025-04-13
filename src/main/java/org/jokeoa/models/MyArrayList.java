package org.jokeoa.models;

import org.jetbrains.annotations.NotNull;
import org.jokeoa.interfaces.ListIn;

import java.util.Iterator;

public class MyArrayList<T> implements ListIn<T> {

    private Object[] array;
    private int size;

    public MyArrayList() {
        int DEFAULT_CAPACITY = 10;
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    
    public void add(T item) {
        if (size == array.length) {
            increaseCapacity();
        }
        array[size++] = item;
    }

    private void increaseCapacity() {
        int newCapacity = array.length + (array.length >> 1);
        Object[] newArray = new Object[newCapacity];
        myArrayCopy(array, newArray, size);
        array = newArray;
    }

    private void myArrayCopy(Object[] source, Object[] destination, int length) {
        for (int i = 0; i < length; i++) {
            destination[i] = source[i];
        }
    }


    public void set(int index, Object item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        array[index] = item;
    }

    
    public void add(int index, Object item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        array[index] = item;
    }

    
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

    
    public void addLast(Object item) {
        if (size == array.length) {
            increaseCapacity();
        }
        array[size++] = item;
    }


    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) array[index];
    }

    
    public T getFirst() {
        return (T) array[0];
    }

    
    public T getLast() {
        return (T) array[size - 1];
    }

    
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null;
    }

    
    public void removeFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Size: " + size);
        }
        for (int i = 0; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
    }

    
    public void removeLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Size: " + size);
        }
        array[--size] = null;
    }

    
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (((Comparable) array[j]).compareTo(array[j + 1]) > 0) {
                    Object temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    
    public boolean exists(Object object) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(object)) {
                return true;
            }
        }
        return false;
    }

    
    public Object[] toArray() {
        Object[] newArray = new Object[size];
        return new Object[0];
    }

    
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;

    }

    
    public int size() {
        return size;
    }


    public @NotNull Iterator iterator() {
        return null;
    }
}
