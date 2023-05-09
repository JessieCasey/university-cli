package com.university.cambridge.console;

import com.university.cambridge.strategies.DepartmentInfoStrategy;
import com.university.cambridge.strategies.GlobalSearchStrategy;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.university.cambridge.ApplicationConstants.ConsoleResponse.HELP_RESPONSE;

@Component
@RequiredArgsConstructor
public class CommandFactory {

    private final DepartmentInfoStrategy departmentInfoStrategy;
    private final GlobalSearchStrategy globalSearchStrategy;

    /**
     * Executes the command entered by the user.
     * @param userInput the user's input command
     * @return the result of the executed command
     */
    public String executeCommand(final String userInput) {
        Command command = returnCommandFromInput(userInput.trim().toLowerCase());

        if (!command.commandStrategy.equals(CommandStrategy.HELP) && command.argument == null) {
            return "Invalid user input.";
        }
        switch (command.commandStrategy) {
            case WHO -> {
                return departmentInfoStrategy.getHeadOfDepartment(command.argument);
            }
            case SHOW_STATISTICS -> {
                return departmentInfoStrategy.getDepartmentStatistics(command.argument);
            }
            case SHOW_AVERAGE_SALARY -> {
                return departmentInfoStrategy.getDepartmentAverageSalary(command.argument);
            }
            case SHOW_EMPLOYEE_COUNT -> {
                return departmentInfoStrategy.getDepartmentEmployeeCount(command.argument);
            }
            case GLOBAL_SEARCH -> {
                return globalSearchStrategy.search(command.argument);
            }
            case HELP -> {
                return HELP_RESPONSE;
            }
            default -> {
                return "Unknown command.";
            }
        }
    }

    /**
     * Returns a Command object based on the user's input.
     * @param userInput the user's input command
     * @return the Command object
     */
    private Command returnCommandFromInput(final String userInput) {
        String argument;

        Pattern headOfDepartmentPattern = Pattern.compile("^who\\s+is\\s+head\\s+of\\s+department\\s+(.+)$");
        Matcher headOfDepartmentMatcher = headOfDepartmentPattern.matcher(userInput);
        if (headOfDepartmentMatcher.find()) {
            argument = headOfDepartmentMatcher.group(1);
            return Command.builder().argument(argument).commandStrategy(CommandStrategy.WHO).build();
        }

        Pattern departmentStatisticsPattern = Pattern.compile("^show\\s+(.+)\\s+statistics\\s*$");
        Matcher departmentStatisticsMatcher = departmentStatisticsPattern.matcher(userInput);
        if (departmentStatisticsMatcher.find()) {
            argument = departmentStatisticsMatcher.group(1);
            return Command.builder().argument(argument).commandStrategy(CommandStrategy.SHOW_STATISTICS).build();
        }

        Pattern departmentSalaryPattern = Pattern.compile("^show\\s+the\\s+average\\s+salary\\s+for\\s+the\\s+department\\s+(.+)$");
        Matcher departmentSalaryMatcher = departmentSalaryPattern.matcher(userInput);
        if (departmentSalaryMatcher.find()) {
            argument = departmentSalaryMatcher.group(1);
            return Command.builder().argument(argument).commandStrategy(CommandStrategy.SHOW_AVERAGE_SALARY).build();
        }

        Pattern employeeCountPattern = Pattern.compile("^show\\s+count\\s+of\\s+employee\\s+for\\s+(.+)$");
        Matcher employeeCountMatcher = employeeCountPattern.matcher(userInput);
        if (employeeCountMatcher.find()) {
            argument = employeeCountMatcher.group(1);
            return Command.builder().argument(argument).commandStrategy(CommandStrategy.SHOW_EMPLOYEE_COUNT).build();
        }

        Pattern globalSearchPattern = Pattern.compile("^global\\s+search\\s+by\\s+(.+)$");
        Matcher globalSearchMatcher = globalSearchPattern.matcher(userInput);
        if (globalSearchMatcher.find()) {
            argument = globalSearchMatcher.group(1);
            return Command.builder().argument(argument).commandStrategy(CommandStrategy.GLOBAL_SEARCH).build();
        }

        if (userInput.trim().equals("help")) {
            return Command.builder().commandStrategy(CommandStrategy.HELP).build();
        }

        return Command.builder().commandStrategy(CommandStrategy.UNKNOWN).build();
    }

    @Builder
    private static class Command {
        private String argument;
        private CommandStrategy commandStrategy;
    }

    private enum CommandStrategy {
        WHO, SHOW_STATISTICS, SHOW_AVERAGE_SALARY, SHOW_EMPLOYEE_COUNT, GLOBAL_SEARCH, HELP, UNKNOWN
    }

}
