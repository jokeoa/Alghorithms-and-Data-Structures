package org.jokeoa.factory;

import org.jokeoa.interfaces.InputProvider;
import org.jokeoa.models.Operator;

public class OperatorFactory<T> {
    private final InputProvider<T> inputProvider;

    public OperatorFactory(InputProvider<T> inputProvider) {
        this.inputProvider = inputProvider;
    }

    public Operator<T> createOperator() {
        return new Operator<>(inputProvider);
    }

    public Operator<T> createOperatorWithArray(int size) {
        Operator<T> operator = new Operator<>(inputProvider, size);
        operator.setArray();
        return operator;
    }
}
