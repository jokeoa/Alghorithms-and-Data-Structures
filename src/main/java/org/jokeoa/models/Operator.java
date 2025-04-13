package org.jokeoa.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.jokeoa.interfaces.InputProvider;
import org.jokeoa.interfaces.OperatorIn;

@Data
public class Operator<T> implements OperatorIn<T> {
    @Setter(AccessLevel.NONE) @Getter private T value;
    @Setter(AccessLevel.NONE) @Getter private T[] array;
    private final InputProvider<T> inputProvider;
    private final int size;
    private int currentIndex = 0;

    public Operator(InputProvider<T> inputProvider) {
        this.inputProvider = inputProvider;
        this.size = 0;
        setValue();
    }
    
    public Operator(InputProvider<T> inputProvider, int size) {
        this.inputProvider = inputProvider;
        this.size = size;
        setValue();
    }
    
    public Operator(InputProvider<T> inputProvider, int size, boolean setInitialValue) {
        this.inputProvider = inputProvider;
        this.size = size;
        if (setInitialValue) {
            setValue();
        }
    }

    @Override
    public void setArray() {
        System.out.println("Enter " + size + " values:");
        this.array = inputProvider.getArray(size);
        this.currentIndex = 0;
    }

    @Override
    public void setValue() {
        System.out.println("Enter a value:");
        this.value = inputProvider.getValue();
    }
    
    public boolean hasNext() {
        return array != null && currentIndex < array.length;
    }
    
    
    public T next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more elements available");
        }

        return array[currentIndex++];
    }

}