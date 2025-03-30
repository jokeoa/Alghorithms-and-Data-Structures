package org.jokeoa;

import org.jokeoa.tasks.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Number Processing System ===");
        System.out.println("1. Run Task 1");
        System.out.println("2. Run Task 2");
        System.out.println("3. Run Task 3");
        System.out.println("4. Run Task 4");
        System.out.println("5. Run Task 5");
        System.out.println("6. Run Task 6");
        System.out.println("7. Run Task 7 (Reverse Array)");
        System.out.println("8. Exit");
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
                Task4.main(null);
                break;
            case 5:
                Task5.main(null);
                break;
            case 6:
                Task6.main(null);
                break;
            case 7:
                Task7.main(null);
                break;
            case 8:
                System.out.println("Exiting the program.");
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
        }
    }
}