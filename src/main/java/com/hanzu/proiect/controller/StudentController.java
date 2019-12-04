package com.hanzu.proiect.controller;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hanzu.proiect.persistence.dao.StudentDAO;
import com.hanzu.proiect.persistence.entity.Student;

@Path("/student")
public class StudentController {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	StudentDAO studentDAO = context.getBean(StudentDAO.class);
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudents(){
		return studentDAO.displayStudents();
		
	}
	
	@GET
	@Path("/student")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudents(@PathParam("student") String username){
		return studentDAO.getUserByUsername(username);
	}
	
	@DELETE
	@Path("/{studID}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteStudent(@PathParam("studID") Integer studID) {
		studentDAO.deleteStudent(studID);
	}
}
