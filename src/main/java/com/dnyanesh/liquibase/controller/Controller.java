package com.dnyanesh.liquibase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dnyanesh.liquibase.model.Student;
import com.dnyanesh.liquibase.repository.StudentRepository;

@RestController
@RequestMapping("students")
public class Controller {

	@Autowired
	private StudentRepository studentRepository;

	@PostMapping("student")
	public String createStudent(@RequestParam String name) {
		studentRepository.save(new Student(0, name, "Santa Clara University", "Toronto", "12345"));
		return studentRepository.findByName(name) + " Saved successfully";
	}

	@GetMapping("student")
	public List<Student> getAllStudents() {
		return (List<Student>) studentRepository.findAll();
	}

}