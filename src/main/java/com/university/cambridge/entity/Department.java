package com.university.cambridge.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@Table(name = "department")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Department {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long departmentId;

    @Column(name = "department_name", unique = true, nullable = false)
    String departmentName;

    @OneToOne
    @JoinColumn(name = "head_of_department_id", unique = true)
    Lector headOfDepartment;
}