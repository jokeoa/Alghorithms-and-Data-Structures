# Algorithms and Data Structures Project

![Java](https://img.shields.io/badge/Language-Java-orange)
![Status](https://img.shields.io/badge/Status-Active-brightgreen)
![Last Updated](https://img.shields.io/badge/Last%20Updated-2025--04--02-blue)
![License](https://img.shields.io/npm/l/@tiptap/core.svg)

## Overview
This project is developed for the ADS (Algorithms and Data Structures) laboratory work. It is a simple Java application that demonstrates the use of Maven for dependency management, Lombok for boilerplate code reduction, and practical implementations of various algorithms and data structures.

## Features
- **Interactive Console Interface**: User-friendly command-line interface for input and output operations
- **Input Processing**: Efficient handling of integer and array inputs
- **Modular Design**: Well-structured code with separation of concerns following OOP principles
- **Data Structure Implementations**: Examples of fundamental data structures
- **Algorithm Demonstrations**: Practical examples of important algorithms

## Project Structure
- `pom.xml`: Maven configuration file.
- `src/main/java/org/jokeoa/models/Operator.java`: Contains the `Operator` class which handles input operations.
- `src/main/java/org/jokeoa/models/ConsoleInputProvider.java`: Contains the `ConsoleInputProvider` class which implements the `InputProvider` interface for console input.
- `src/main/java/org/jokeoa/Main.java`: The main entry point of the application.

## Dependencies
- **Lombok**: Used to reduce boilerplate code such as getters, setters, and constructors.
- **JetBrains Annotations**: Used for code annotations and enhanced IDE support.

## Classes and Interfaces

### Operator
- **Package**: `org.jokeoa.models`
- **Description**: Handles input operations for an integer and an array of integers.
- **Fields**:
  - `n`: An integer value.
  - `arr`: An array of integers.
  - `inputProvider`: An instance of `InputProvider`.
- **Methods**:
  - `setArr()`: Prompts the user to enter `n` integers and stores them in `arr`.
  - `setN()`: Prompts the user to enter an integer value for `n`.

### ConsoleInputProvider
- **Package**: `org.jokeoa.models`
- **Description**: Implements the `InputProvider` interface to provide input from the console.
- **Methods**:
  - `getInt()`: Reads an integer from the console.
  - `getIntArray(int size)`: Reads an array of integers from the console.
### Main
- **Package**: `org.jokeoa`
- **Description**: The main entry point of the application.
- **Methods**:
  - `main(String[] args)`: The main method which starts the application.

## Task Implementations

The project includes multiple task implementations that demonstrate various algorithms and data structure concepts:

### Task1
- **Purpose**: Find the minimum element in an array of numbers
- **Key Method**: `findMinimum(Operator<T> operator)`
- **Algorithm**: Linear search through array elements to find the minimum value

### Task2
- **Purpose**: Calculate the average of values in an array
- **Key Method**: `calculateAverage(Operator<T> operator)`
- **Algorithm**: Sums all elements and divides by the array length

### Task3
- **Purpose**: Check if a number is prime
- **Key Method**: `isPrime(int number)`
- **Algorithm**: Tests divisibility up to the square root of the number

### Task4
- **Purpose**: Calculate factorial of a number
- **Key Method**: `findFactorial(Integer value)`
- **Algorithm**: Recursive multiplication approach for factorial calculation

### Task6
- **Purpose**: Calculate power of a number using recursion
- **Key Method**: `calculatePower(Integer base, Integer exponent)`
- **Algorithm**: Recursive multiplication for exponentiation

### Task7
- **Purpose**: Reverse an array in place
- **Key Method**: `reverseArrayInPlace(Integer[] array)`
- **Algorithm**: Recursive approach swapping elements from both ends

## Data Structures

### Binary Search Tree (BST)
The Binary Search Tree (BST) is a data structure that stores elements in a hierarchical order. Each node has at most two children, referred to as the left and right child. The left subtree contains nodes with values less than the parent node, and the right subtree contains nodes with values greater than the parent node.

#### Features:
- Efficient search, insertion, and deletion operations.
- Average time complexity: O(log n).
- Worst-case time complexity: O(n) (when the tree becomes unbalanced).

#### Usage:
- Searching for elements.
- Sorting data.
- Implementing associative arrays.

### MyHashtable
The `MyHashtable` is a custom implementation of a hash table, which is a data structure that maps keys to values using a hash function.

#### Features:
- Fast lookups, insertions, and deletions.
- Handles collisions using techniques like chaining or open addressing.
- Average time complexity: O(1) for basic operations.

#### Usage:
- Storing and retrieving key-value pairs efficiently.
- Implementing caches or dictionaries.

## How to Run
1. Ensure you have Maven installed.
2. Navigate to the project directory.
3. Run the following command to compile and execute the project:
   ```sh
   mvn clean install
   mvn exec:java -Dexec.mainClass="org.jokeoa.Main"
`