package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Employee;


public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

	boolean existsByEmail(String email);
	Optional<Employee> findById(Long id);
}
