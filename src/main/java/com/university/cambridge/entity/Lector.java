package com.university.cambridge.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "lector")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Lector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long lectorId;

    @Column(name = "lector_first_name", nullable = false)
    String lectorFirstName;

    @Column(name = "lector_last_name", nullable = false)
    String lectorLastName;

    @Column(name = "lector_degree", nullable = false)
    @Enumerated(EnumType.STRING)
    Degree lectorDegree;

    @ManyToMany
    @JoinTable(
            name = "lector_departments",
            joinColumns = @JoinColumn(name = "lector_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id")
    )
    List<Department> departments;

    @Column(name = "salary_in_usd", nullable = false)
    Double salaryInUSD;
}
