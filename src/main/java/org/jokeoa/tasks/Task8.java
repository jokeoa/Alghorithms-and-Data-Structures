package org.jokeoa.tasks;

import org.jokeoa.factory.OperatorFactory;
import org.jokeoa.models.ConsoleInputProvider;
import org.jokeoa.models.Operator;

import java.util.Scanner;

public class Task8 {
    public final String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    /**
     * Checks if a string contains only alphabetic characters.
     * 
     * Time Complexity: O(n)
     * Where n is the length of the string.
     * The method checks each character exactly once.
     *
     * @param str the string to check
     * @return true if the string contains only alphabetic characters, false otherwise
     */
    public static boolean myIsAlpha(String str) {
        return myIsAlphaHelper(str, 0);
    }

    /**
     * Helper method for myIsAlpha that implements the recursive check.
     * 
     * Time Complexity: O(n)
     * @param str the string to check
     * @param index the current index in the string
     * @return true if all characters from index to the end are alphabetic, false otherwise
     */
    private static boolean myIsAlphaHelper(String str, int index) {
        if (index >= str.length()) {
            return true;
        }
        char c = str.charAt(index);
        if (!Character.isLetter(c)) {
            return false;
        }
        return myIsAlphaHelper(str, index + 1);
    }

    /**
     * Main method to demonstrate the task.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        // TODO : Implement the ConsoleInputProvider and OperatorFactory classes
        String str = scanner.next();

        System.out.println(myIsAlpha(str)? "No" : "Yes");

    }
}
