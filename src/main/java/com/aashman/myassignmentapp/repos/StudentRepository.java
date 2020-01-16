package com.aashman.myassignmentapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aashman.myassignmentapp.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
