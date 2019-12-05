package com.hanzu.proiect.persistence.dao;


import java.util.List;

import com.hanzu.proiect.persistence.entity.Student;

public interface StudentDAO {
	  void saveOrUpdate(final Student student);
	  public void insera(String username,String email, String password);
	  void readAll();
	  public List<Student> displayStudent();
	  void deleteStudent(Integer studID);
	  public Student getUserByUsername(String username);
}
