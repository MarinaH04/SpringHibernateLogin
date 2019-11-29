package com.hanzu.proiect.persistence.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;




@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentID;
	
	@Column(name="username")
	private String username;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = 
		{ 		
				CascadeType.DETACH, 
				CascadeType.MERGE, 
				CascadeType.REFRESH,
				CascadeType.PERSIST 
		},
		targetEntity = Cursuri.class)
	@JoinTable(name = "studcurs", joinColumns = { 
			@JoinColumn(name = "studID", nullable = false, updatable = true) }, 
			inverseJoinColumns = { @JoinColumn(name = "cursuriID", 
					nullable = false, updatable = true) })
	private List<Cursuri> cursuri = new ArrayList<Cursuri>();
	
	public Student() {}
	public Student(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	  public void addCursuri(Cursuri curs) {
		    System.out.printf("Adding course '%s' to '%s' \n", curs.getDenumire(), this.username);
		    cursuri.add(curs); 
		  }
	
	public Integer getStudentID() {
		return studentID;
	}

	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public List<Cursuri> getCursuri() {
		return cursuri;
	}
	public void setCursuri(List<Cursuri> cursuri) {
		this.cursuri = cursuri;
	}
	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", username=" + username + ", email=" + email + ", password="
				+ password + ", cursuri=" + cursuri +"]";
	}
	
	
}
