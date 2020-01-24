package com.aashman.myassignmentapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aashman.myassignmentapp.models.McQuestion;

public interface McQuestionsRepository extends JpaRepository<McQuestion, Integer> {

}
