package com.university.cambridge;

import lombok.experimental.UtilityClass;

/**
 * Contains various constants used in the university application.
 */
@UtilityClass
public class ApplicationConstants {

    /**
     * Inner utility class of constants for console responses .
     */
    @UtilityClass
    public final class ConsoleResponse {
        public static final String DEPARTMENT_NOT_FOUND = "Sorry, the department you entered was not found. Please try a different department name.";
        public static final String HEAD_DEPARTMENT_NOT_FOUND = "Sorry, the head of department you requested could not be found.";
        public static final String NO_SALARY_FOUND = "Sorry, we could not find any salary information for the department '%s'. Please try a different department name.";
        public static final String LECTORS_NOT_FOUND = "Sorry, we could not find any lecturers for the department '%s'. Please try a different department name.";

        public static final String HEAD_RESPONSE = "Head of %s department is %s.";

        public static final String SHOW_STATISTICS_RESPONSE = """
                Assistants - %s
                Associate professors - %s
                Professors - %s""";

        public static final String SHOW_AVERAGE_SALARY = "The average salary of %s is %s";

        public static final String LINE = "+---------------------------------------------------------+";

        public static final String WELCOME_MESSAGE = """
                +---------------------------------------------------------+\s
                | Welcome to the University Console App!                  |\s
                | Type 'help' to see a list of available commands.        |\s
                | Version 0.1                                             |\s
                +---------------------------------------------------------+\s
                """;

        public static final String HELP_RESPONSE = """
                | The app should implement such commands:
                | 1. User Input: Who is head of department {department_name}
                |    Answer: Head of {department_name} department is {head_of_department_name}
                | \s
                | 2. User Input: Show {department_name} statistics.
                |    Answer: assistans - {assistams_count}.
                |            associate professors - {associate_professors_count}
                |            professors - {professors_count}
                | \s
                | 3. User Input: Show the average salary for the department {department_name}.
                |    Answer: The average salary of {department_name} is {average_salary}
                | \s
                | 4. User Input: Show count of employee for {department_name}.
                |    Answer: {employee_count}
                | \s
                | 5. User Input: Global search by {template}. \s
                |    Example: Global search by van
                |    Answer: Ivan Petrenko, Petro Ivanov""";

    }

}

