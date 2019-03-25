package com.edu.dao;

import java.util.List;

import com.edu.domain.Student;

public interface StudentMapper
{

	/**
	 * 查询所有数据
	 */
	public List<Student> findAll();

	/**
	 * 保存数据
	 * @param student
	 */
	public void save(Student student);

	/**
	 * 根据id 查询对象
	 * @param id
	 * @return
	 */
	public Student findById(Integer id);
	
	/**
	 * 修改对象数据
	 * @param student
	 */
	public void update(Student student);

	/**
	 * 删除数据
	 * @param id
	 */
	public void delete(Integer[] id);
	
	/**
	 * 查询关联表,一般不用
	 */
	public List<Student> queryResultMap();
}
