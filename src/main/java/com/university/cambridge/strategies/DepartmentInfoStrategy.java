package com.university.cambridge.strategies;

public interface DepartmentInfoStrategy {
    String getHeadOfDepartment(String departmentName);
    String getDepartmentStatistics(String departmentName);
    String getDepartmentAverageSalary(String departmentName);
    String getDepartmentEmployeeCount(String departmentName);
}
