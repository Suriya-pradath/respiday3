package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepo;

@Service
public class SpringappApplication implements ApiService {
	@Autowired
	private EmployeeRepo taskRepository;
	
	@Override
    public boolean addTask(Employee task) {
		// TODO Auto-generated method stub
		boolean taskExists = taskRepository.existsByEmail(task.getEmail());
		if(!taskExists) {
			taskRepository.save(task);
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public List<Employee> getTask(){
		return taskRepository.findAll();
	}

	@Override
	public boolean updateTask(Long id,Employee task) {
		
		//taskRepository.saveAndFlush(task);
		Optional<Employee> existingTaskOptional =taskRepository.findById(id);
		if(existingTaskOptional.isPresent()) {
			
			Employee taskExists=existingTaskOptional.get();
			taskExists.setName(task.getName());
			taskExists.setPassword(task.getPassword());
			taskExists.setEmail(task.getEmail());
			taskRepository.save(taskExists);
			return true;
		}
		else {
			return false;
		}
	}
 

}
