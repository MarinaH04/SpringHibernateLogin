package com.hanzu.proiect.persistence.dao;


import java.util.List;

import com.hanzu.proiect.persistence.entity.Student;

public interface StudentDAO {
	  void saveOrUpdate(final Student student);

	  void readAll();
	  public void displayStudent();
	  public List<Student> displayStudents();
	  void deleteStudent(Integer studID);
	  public Student getUserByUsername(String username);
}
