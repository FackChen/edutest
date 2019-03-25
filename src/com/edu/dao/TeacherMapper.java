package com.edu.dao;

import java.util.List;

import com.edu.domain.Teacher;

public interface TeacherMapper
{

	/**
	 * 查询所有数据
	 */
	public List<Teacher> findAll();

	/**
	 * 保存数据
	 * @param teacher
	 */
	public void save(Teacher teacher);

	/**
	 * 根据id 查询对象
	 * @param id
	 * @return
	 */
	public Teacher findById(Integer id);
	
	/**
	 * 修改对象数据
	 * @param teacher
	 */
	public void update(Teacher teacher);

	/**
	 * 删除数据
	 * @param id
	 */
	public void delete(Integer[] id);
}
