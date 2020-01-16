package com.aashman.myassignmentapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aashman.myassignmentapp.models.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer>{

}
