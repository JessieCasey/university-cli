package com.university.cambridge.console;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static com.university.cambridge.ApplicationConstants.ConsoleResponse.LINE;
import static com.university.cambridge.ApplicationConstants.ConsoleResponse.WELCOME_MESSAGE;

@Component
@RequiredArgsConstructor
public class ConsoleApp implements CommandLineRunner {

    private final CommandFactory commandFactory;
    private final ApplicationContext applicationContext;

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
