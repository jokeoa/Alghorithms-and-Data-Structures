# ADS Project


## Overview
This project is developed for the ADS (Algorithms and Data Structures) laboratory work. It is a simple Java application that demonstrates the use of Maven for dependency management, Lombok for boilerplate code reduction, and custom input handling.
## Project Structure
- `pom.xml`: Maven configuration file.
- `src/main/java/org/jokeoa/models/Operator.java`: Contains the `Operator` class which handles input operations.
- `src/main/java/org/jokeoa/models/ConsoleInputProvider.java`: Contains the `ConsoleInputProvider` class which implements the `InputProvider` interface for console input.
- `src/main/java/org/jokeoa/Main.java`: The main entry point of the application.

## Dependencies
- **Lombok**: Used to reduce boilerplate code such as getters, setters, and constructors.
- **JetBrains Annotations**: Used for code annotations.

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

## How to Run
1. Ensure you have Maven installed.
2. Navigate to the project directory.
3. Run the following command to compile and execute the project:
   ```sh
   mvn clean install
   mvn exec:java -Dexec.mainClass="org.jokeoa.Main"