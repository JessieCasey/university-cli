package com.university.cambridge.strategies.impl;

import com.university.cambridge.entity.Degree;
import com.university.cambridge.entity.Department;
import com.university.cambridge.entity.Lector;
import com.university.cambridge.repository.DepartmentRepository;
import com.university.cambridge.repository.LectorRepository;
import com.university.cambridge.strategies.DepartmentInfoStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.university.cambridge.ApplicationConstants.ConsoleResponse.*;

@Service
@RequiredArgsConstructor
public class DepartmentInfoServiceImpl implements DepartmentInfoStrategy {

    private final DepartmentRepository departmentRepository;
    private final LectorRepository lectorRepository;

    @Override
    public String getHeadOfDepartment(final String departmentName) {
        Department department = departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
        if (department == null) {
            return DEPARTMENT_NOT_FOUND;
        }

        Lector head = department.getHeadOfDepartment();

        if (head == null) {
            return HEAD_DEPARTMENT_NOT_FOUND;
        }

        return HEAD_RESPONSE.formatted(departmentName, head.getLectorFirstName());
    }

    @Override
    public String getDepartmentStatistics(final String departmentName) {
        Department department = departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
        if (department == null) {
            return DEPARTMENT_NOT_FOUND;
        }

        int assistants = lectorRepository.countByDepartmentsAndLectorDegree(department, Degree.ASSISTANT);
        int associateProfessors = lectorRepository.countByDepartmentsAndLectorDegree(department, Degree.ASSOCIATE_PROFESSOR);
        int professors = lectorRepository.countByDepartmentsAndLectorDegree(department, Degree.PROFESSOR);

        return SHOW_STATISTICS_RESPONSE.formatted(assistants, associateProfessors, professors);
    }

    @Override
    public String getDepartmentAverageSalary(final String departmentName) {
        Department department = departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
        if (department == null) {
            return DEPARTMENT_NOT_FOUND;
        }

        Double averageSalary = lectorRepository.findAverageSalaryByDepartment(department);
        if (averageSalary == null) {
            return NO_SALARY_FOUND.formatted(departmentName);
        }

        return SHOW_AVERAGE_SALARY.formatted(departmentName, String.format("%.2f", averageSalary));
    }

    @Override
    public String getDepartmentEmployeeCount(final String departmentName) {
        Department department = departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
        if (department == null) {
            return DEPARTMENT_NOT_FOUND;
        }

        long employeeCount = lectorRepository.countByDepartments(department);

        return String.valueOf(employeeCount);
    }
}
