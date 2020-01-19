package com.aashman.myassignmentapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aashman.myassignmentapp.models.StudentRequest;

public interface StudentRequestRepository extends JpaRepository<StudentRequest, Integer>{
}
