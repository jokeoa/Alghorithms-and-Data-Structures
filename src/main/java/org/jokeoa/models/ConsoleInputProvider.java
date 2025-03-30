package org.jokeoa.models;

import org.jokeoa.interfaces.InputProvider;

import java.util.Scanner;
import java.lang.reflect.Array;

public class ConsoleInputProvider<T> implements InputProvider<T> {
    private final Scanner scanner = new Scanner(System.in);
    private final Class<T> type;
    
    public ConsoleInputProvider(Class<T> type) {
        this.type = type;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T getValue() {
        if (type == Integer.class) {
            return (T) Integer.valueOf(scanner.nextInt());
        } else if (type == Double.class) {
            return (T) Double.valueOf(scanner.nextDouble());
        } else if (type == String.class) {
            return (T) scanner.next();
        } else if (type == Boolean.class) {
            return (T) Boolean.valueOf(scanner.nextBoolean());
        } else {
            throw new UnsupportedOperationException("Type not supported: " + type.getName());
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T[] getArray(int size) {
        T[] arr = (T[]) Array.newInstance(type, size);
        for (int i = 0; i < size; i++) {
            arr[i] = getValue();
        }
        return arr;
    }
}