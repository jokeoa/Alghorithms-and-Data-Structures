package org.jokeoa.interfaces;

public interface InputProvider<T> {
    T getValue();
    T[] getArray(int size);
}
