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
    
    /**
     * Creates an array operator that only gets array input without asking for a single value.
     * This helps avoid the double prompt issue.
     * 
     * @param size The size of the array
     * @return A new Operator with array data
     */
    public Operator<T> createArrayOperator(int size) {
        Operator<T> operator = new Operator<>(inputProvider, size, false);
        operator.setArray();
        return operator;
    }
}
