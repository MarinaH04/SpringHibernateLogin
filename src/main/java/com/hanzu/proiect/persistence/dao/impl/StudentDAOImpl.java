package com.hanzu.proiect.persistence.dao.impl;

import java.util.List;

import javax.transaction.Transactional;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
		new PersistanceOperations().saveOrUpdate(sessionFactory, student,"Student: "+student.getUsername()+" saved!");
	}

	@SuppressWarnings("unchecked")
	@Override
	public void readAll() {
		final List<Student> detailList = sessionFactory.getCurrentSession().createCriteria(Student.class).list();

	    for (final Student stud : detailList){
	      System.out.printf(" Id:%s \t Username:%s \t Email:%s \t Password:%s \n", stud.getStudentID(), stud.getUsername(), stud.getEmail(), stud.getPassword());
	    }
	}
	
	@SuppressWarnings("unchecked")
	public List<Student> displayStudents() {
		List<Student> studenti = sessionFactory.getCurrentSession().createCriteria(Student.class).list();
		return studenti;
	}
	public List<Student> displayStudent(){
		Session session = this.sessionFactory.openSession();
		List<Student> result = null;
		try {
		
		 result = session.createQuery("FROM Student").list();
		
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return result;
	}
	
	public void deleteStudent(Integer studID) {
		 Session session = sessionFactory.openSession();
		 session.beginTransaction();
		  Student student = (Student)session.load(Student.class, studID);
		
		session.delete(student);
		 
		  session.getTransaction().commit();
		  
		    
	 System.out.println("Deleted Successfully");
	}
	public Student getUserByUsername(String username){
		 Session session = sessionFactory.getCurrentSession();
		return (Student) session.createCriteria(Student.class).add(Restrictions.eq("username", username)).uniqueResult();
	}

}
