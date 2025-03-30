package org.jokeoa.interfaces;

public interface OperatorIn<T> {
    void setValue();
    void setArray();
    T getValue();
    T[] getArray();
}
