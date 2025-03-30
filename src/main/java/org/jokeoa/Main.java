package org.jokeoa;

import org.jetbrains.annotations.NotNull;
import org.jokeoa.factory.OperatorFactory;
import org.jokeoa.models.ConsoleInputProvider;
import org.jokeoa.models.Operator;

import java.io.Console;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Example with Integer type
        ConsoleInputProvider<Integer> intInputProvider = new ConsoleInputProvider<>(Integer.class);
        OperatorFactory<Integer> intFactory = new OperatorFactory<>(intInputProvider);
        
        System.out.println("Working with Integers:");
        Operator<Integer> intOperator = intFactory.createOperator();
        System.out.println("Single integer value: " + intOperator.getValue());
        
        // Create an operator with an array of integers
        System.out.println("\nWorking with Integer Array:");
        Operator<Integer> intArrayOperator = intFactory.createOperatorWithArray(3);
        System.out.print("Integer array values: ");
        for (Integer val : intArrayOperator.getArray()) {
            System.out.print(val + " ");
        }
        System.out.println();
        
        // Example with Double type
        System.out.println("\nWorking with Doubles:");
        ConsoleInputProvider<Double> doubleInputProvider = new ConsoleInputProvider<>(Double.class);
        OperatorFactory<Double> doubleFactory = new OperatorFactory<>(doubleInputProvider);
        Operator<Double> doubleOperator = doubleFactory.createOperator();
        System.out.println("Single double value: " + doubleOperator.getValue());
        
        // Example with String type
        System.out.println("\nWorking with Strings:");
        ConsoleInputProvider<String> stringInputProvider = new ConsoleInputProvider<>(String.class);
        OperatorFactory<String> stringFactory = new OperatorFactory<>(stringInputProvider);
        Operator<String> stringArrayOperator = stringFactory.createOperatorWithArray(2);
        System.out.print("String array values: ");
        for (String val : stringArrayOperator.getArray()) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}