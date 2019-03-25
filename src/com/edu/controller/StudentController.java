package com.edu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.domain.Student;
import com.edu.service.StudentService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Resource
	private StudentService studentService;

	private Map<String,Object> result = new HashMap<String,Object>();
	
	/**
	 * 查询所有数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public List<Student> list(){
		List<Student> list = studentService.findAll();
		return list;
	}

	/**
	 * 分页查询
	 */
	@RequestMapping("/listByPage")
	@ResponseBody
	public Map<String,Object> listByPage(Integer page,Integer rows){
		PageHelper.startPage(page, rows);
		List<Student> list = studentService.findAll();
		
		PageInfo<Student> pageInfo = new PageInfo<Student>(list);
		
		long total = pageInfo.getTotal();
		List<Student> custList = pageInfo.getList();
		
		result.put("total", total);
		result.put("rows", custList);
		
		return result;
	}

	/**
	 * 保存数据
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Map<String,Object> save(Student student){
		try {
			studentService.save(student);
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", e.getMessage());
		}
		return result;
	}

	/**
	 * 根据id 查询对象
	 */
	@RequestMapping("/findById")
	@ResponseBody
	public Student findById(Integer id){
		Student cust = studentService.findById(id);
		return cust;
	}

	/**
	 * 删除数据
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String,Object> delete(Integer[] id){
		try {
			studentService.delete(id);
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", e.getMessage());
		}
		return result;
	}
}
