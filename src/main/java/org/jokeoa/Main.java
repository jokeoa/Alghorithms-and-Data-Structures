package org.jokeoa;

import org.jokeoa.weeks.week1.tasks.*;

import java.util.Scanner;

public class Main {
    public static final int taskCount = 10;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < taskCount; i++) {
            System.out.println("Task " + (i + 1));
        }
        System.out.println("11. Exit");
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
                Task8.main(null);
                break;
            case 9:
                Task9.main(null);
                break;
            case 10:
                Task10.main(null);
                break;
            case 11:
                System.out.println("Exiting the program.");
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
        }
    }
}