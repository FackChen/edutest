package com.edu.serviceI.mpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.dao.StudentMapper;
import com.edu.domain.Student;
import com.edu.service.StudentService;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {

	@Resource
	private StudentMapper studentMapper;
	
	public List<Student> findAll() {
		return studentMapper.findAll();
	}

	public void save(Student student) {
		if(student.getId()!=null){
			studentMapper.update(student);
		}else{
			studentMapper.save(student);
		}
	}

	public Student findById(Integer id) {
		return studentMapper.findById(id);
	}

	public void delete(Integer[] id) {
		studentMapper.delete(id);
	}

}

