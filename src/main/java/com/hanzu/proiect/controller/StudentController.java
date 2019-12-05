package com.hanzu.proiect.controller;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
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
		return studentDAO.displayStudent();
		
	}
	
	@GET
	@Path("/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudents(@PathParam("username") String username){
		return studentDAO.getUserByUsername(username);
	}
	
	@DELETE
	@Path("/{studID}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteStudent(@PathParam("studID") Integer studID) {
		studentDAO.deleteStudent(studID);
	}
	
	@POST
	@Path("/stud")
	@Produces(MediaType.APPLICATION_JSON)
	public void addStudent(String str) {
		
		String password="";
		String username="";
		String email="";
		try {
			JSONObject object = new JSONObject(str);
			username = (String) object.get("username");
			email = (String) object.get("email");
			password = (String) object.get("password");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		studentDAO.insera(username, email, password);
	}
}
