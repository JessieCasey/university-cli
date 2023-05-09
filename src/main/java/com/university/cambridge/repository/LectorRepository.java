package com.university.cambridge.repository;

import com.university.cambridge.entity.Degree;
import com.university.cambridge.entity.Department;
import com.university.cambridge.entity.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {

    @Query("SELECT CONCAT(l.lectorFirstName, ' ', l.lectorLastName) FROM Lector l WHERE LOWER(l.lectorFirstName) LIKE %:template% OR LOWER(l.lectorLastName) LIKE %:template%")
    List<String> findLectorsByTemplate(@Param("template") String template);

    int countByDepartmentsAndLectorDegree(Department department, Degree lectorDegree);

    @Query("SELECT AVG(l.salaryInUSD) FROM Lector l JOIN l.departments d WHERE d = :department")
    Double findAverageSalaryByDepartment(@Param("department") Department department);


    long countByDepartments(Department department);

}