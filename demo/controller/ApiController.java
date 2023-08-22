package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.ApiService;

@RestController
@RequestMapping("/api/v1/task")
public class ApiController {
	@Autowired
	private ApiService taskService;
	

	
	@PostMapping("/addTask")
	public ResponseEntity<String> addTask(@RequestBody Employee task){
		boolean dataSaved = taskService.addTask(task);
		if(dataSaved) {
			return ResponseEntity.status(200).body("User added successfully!");
		}else {
			return ResponseEntity.status(404).body("Something went wrong!");
		}
	}
	@PutMapping("/updateTask/{id}")
	public ResponseEntity<String> updateTask(@PathVariable Long id,@RequestBody Employee task){
		boolean taskData = taskService.updateTask(id,task);
		if(taskData) {
			return ResponseEntity.status(200).body("User updated successfully!");
		}else {
			return ResponseEntity.status(404).body("No record found to be updated");
		}
	}
}