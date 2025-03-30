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

    @Override
    public void setArray() {
        System.out.println("Enter " + size + " values:");
        this.array = inputProvider.getArray(size);
    }

    @Override
    public void setValue() {
        System.out.println("Enter a value:");
        this.value = inputProvider.getValue();
    }
}