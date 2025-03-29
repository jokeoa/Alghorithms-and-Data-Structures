package org.jokeoa.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.jokeoa.interfaces.InputProvider;
import org.jokeoa.interfaces.OperatorIn;

@Data
public class Operator implements OperatorIn {
    @Setter(AccessLevel.NONE) private int n;
    @Setter(AccessLevel.NONE) private int[] arr;
    private final InputProvider inputProvider;

    public Operator(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
        setN();
    }

    public void setArr() {
        System.out.println("Enter " + n + " integers:");
        this.arr = inputProvider.getIntArray(n);
    }

    public void setN() {
        System.out.println("Enter integer N:");
        this.n = inputProvider.getInt();
    }
}