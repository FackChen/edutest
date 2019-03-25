package com.edu.service;

import java.util.List;

import com.edu.domain.Teacher;

public interface TeacherService
{
	public List<Teacher> findAll();

	public void save(Teacher teacher);

	public Teacher findById(Integer id);

	public void delete(Integer[] id);
}
