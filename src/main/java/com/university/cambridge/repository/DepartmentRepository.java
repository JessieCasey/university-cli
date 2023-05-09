package com.university.cambridge.repository;

import com.university.cambridge.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
    Department findByDepartmentNameIgnoreCase(String departmentName);

}
