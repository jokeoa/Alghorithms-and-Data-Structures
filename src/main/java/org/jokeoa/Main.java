package org.jokeoa;

import org.jokeoa.tasks.Task1;
import org.jokeoa.tasks.Task2;
import org.jokeoa.tasks.Task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("1. Run Task 1 (Find Minimum)");
        System.out.println("2. Run Task 2");
        System.out.println("3. Run Task 3 (Check Prime Number)");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                Task1.main(null);
                break;
            case 2:
                Task2.main(null);
                break;
            case 3:
                Task3.main(null);
                break;
            case 4:
                System.out.println("Exiting the program.");
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
        }
    }
}