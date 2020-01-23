package com.aashman.myassignmentapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aashman.myassignmentapp.models.MultipleChoiceAssignment;

public interface McAssignmentRepository extends JpaRepository<MultipleChoiceAssignment, Integer> {
}
