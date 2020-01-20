package com.aashman.myassignmentapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aashman.myassignmentapp.models.NotificationOfStudent;

public interface NotificationOfStudentRepository extends JpaRepository<NotificationOfStudent, Integer> {

}
