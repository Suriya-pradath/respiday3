package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface ApiService {
	public boolean addTask(Employee task);
	public boolean updateTask(Long id ,Employee task);
	public List<Employee> getTask();
}
