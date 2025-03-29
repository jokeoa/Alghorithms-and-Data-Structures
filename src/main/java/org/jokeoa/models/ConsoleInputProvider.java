package org.jokeoa.models;

import org.jokeoa.interfaces.InputProvider;

import java.util.Scanner;

public class ConsoleInputProvider implements InputProvider {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public int getInt() {
        return scanner.nextInt();
    }

    @Override
    public int[] getIntArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}