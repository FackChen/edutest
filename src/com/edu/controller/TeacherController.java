package com.edu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.domain.Teacher;
import com.edu.service.TeacherService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	@Resource
	private TeacherService teacherService;

	private Map<String,Object> result = new HashMap<String,Object>();
	
	/**
	 * 查询所有数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public List<Teacher> list(){
		List<Teacher> list = teacherService.findAll();
		return list;
	}

	/**
	 * 分页查询
	 */
	@RequestMapping("/listByPage")
	@ResponseBody
	public Map<String,Object> listByPage(Integer page,Integer rows){
		PageHelper.startPage(page, rows);
		List<Teacher> list = teacherService.findAll();
		
		PageInfo<Teacher> pageInfo = new PageInfo<Teacher>(list);
		
		long total = pageInfo.getTotal();
		List<Teacher> custList = pageInfo.getList();
		
		result.put("total", total);
		result.put("rows", custList);
		
		return result;
	}

	/**
	 * 保存数据
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Map<String,Object> save(Teacher teacher){
		try {
			teacherService.save(teacher);
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
	public Teacher findById(Integer id){
		Teacher cust = teacherService.findById(id);
		return cust;
	}

	/**
	 * 删除数据
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String,Object> delete(Integer[] id){
		try {
			teacherService.delete(id);
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", e.getMessage());
		}
		return result;
	}
}
