package org.jokeoa.factory;

import org.jokeoa.interfaces.InputProvider;
import org.jokeoa.models.Operator;

public class OperatorFactory {
    private final InputProvider inputProvider;

    public OperatorFactory(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    public Operator createOperator() {
        return new Operator(inputProvider);
    }

    public Operator createOperatorWithArray() {
        Operator operator = new Operator(inputProvider);
        operator.setArr();
        return operator;
    }
}
