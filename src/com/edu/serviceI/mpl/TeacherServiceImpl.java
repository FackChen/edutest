package com.edu.serviceI.mpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.dao.TeacherMapper;
import com.edu.domain.Teacher;
import com.edu.service.TeacherService;

@Service("teacherService")
@Transactional
public class TeacherServiceImpl implements TeacherService {

	@Resource
	private TeacherMapper teacherMapper;
	
	public List<Teacher> findAll() {
		return teacherMapper.findAll();
	}

	public void save(Teacher teacher) {
		if(teacher.getId()!=null){
			teacherMapper.update(teacher);
		}else{
			teacherMapper.save(teacher);
		}
	}

	public Teacher findById(Integer id) {
		return teacherMapper.findById(id);
	}

	public void delete(Integer[] id) {
		teacherMapper.delete(id);
	}

}

