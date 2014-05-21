package com.aehp.template.dao;

import java.util.List;

import com.aehp.template.domain.Student;

public interface IStudentDao {

	public List<Student> getStudents()
	        throws Exception;

	public void createStudent(Student student)
			throws Exception;

	public void updateStudent(Student student)
	        throws Exception;

}
