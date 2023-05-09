package com.university.cambridge.console;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static com.university.cambridge.ApplicationConstants.ConsoleResponse.LINE;
import static com.university.cambridge.ApplicationConstants.ConsoleResponse.WELCOME_MESSAGE;

/**

 This class represents the console application of the University of Cambridge. It implements CommandLineRunner interface
 and runs a command line interface. It takes input from the user and uses CommandFactory to execute the commands.
 It also uses the Lombok RequiredArgsConstructor annotation to initialize the final fields.
 */

@Component
@RequiredArgsConstructor
public class ConsoleApp implements CommandLineRunner {

    private final CommandFactory commandFactory;
    private final ApplicationContext applicationContext;

    /**
     * This method is called when the application is executed. It displays a welcome message and prompts the user to enter a command.
     * It continues to prompt the user until the user enters 'exit' command to quit. The method then exits the application.
     *
     * @param args The command-line arguments
     */
    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println(WELCOME_MESSAGE);

        while (true) {
            System.out.println("Please enter a command (or 'exit' to quit): ");
            System.out.print("-> ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("\nThank you for using the University of Cambridge console!");
                System.out.println(LINE);
                SpringApplication.exit(applicationContext, () -> 0);
                break;
            }
            String response = commandFactory.executeCommand(input);
            System.out.print("=> ");
            System.out.println(response);
            System.out.println(LINE);
        }
    }
}
