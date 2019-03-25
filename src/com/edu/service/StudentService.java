package com.edu.service;

import java.util.List;

import com.edu.domain.Student;

public interface StudentService
{
	public List<Student> findAll();

	public void save(Student student);

	public Student findById(Integer id);

	public void delete(Integer[] id);
}
