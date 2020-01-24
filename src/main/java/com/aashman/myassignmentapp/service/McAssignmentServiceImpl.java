package com.aashman.myassignmentapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aashman.myassignmentapp.models.MultipleChoiceAssignment;
import com.aashman.myassignmentapp.repos.McAssignmentRepository;

@Service
public class McAssignmentServiceImpl implements McAssignmentService {

	@Autowired
	McAssignmentRepository mcAssignmentRepository;
	
	@Override
	public boolean doesMcAExist(int id) {
		
		try {
		   Optional<MultipleChoiceAssignment> mcA = mcAssignmentRepository.findById(id);
		   if(mcA.isPresent()) {
			   return true;
		   }
		}catch(Exception e) {
			e.getMessage();
		}
		return false;
	}
}
