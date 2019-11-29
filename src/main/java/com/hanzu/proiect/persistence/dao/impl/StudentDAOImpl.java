package com.hanzu.proiect.persistence.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanzu.proiect.common.PersistanceOperations;
import com.hanzu.proiect.persistence.dao.StudentDAO;
import com.hanzu.proiect.persistence.entity.Student;





@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO {
	
	 @Autowired
	 private SessionFactory sessionFactory;
	 
	@Override
	public void saveOrUpdate(Student student) {
		new PersistanceOperations().saveOrUpdate(sessionFactory, student,"Student: "+student.getStudentID() + student.getUsername()+" saved!");
	}

	@SuppressWarnings("unchecked")
	@Override
	public void readAll() {
		final List<Student> detailList = sessionFactory.getCurrentSession().createCriteria(Student.class).list();

	    for (final Student stud : detailList){
	      System.out.printf(" Id:%s \t Username:%s \t Email:%s \t Password:%s \n", stud.getStudentID(), stud.getUsername(), stud.getEmail(), stud.getPassword());
	    }
	}

}
