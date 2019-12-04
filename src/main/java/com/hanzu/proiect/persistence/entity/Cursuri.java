package com.hanzu.proiect.persistence.entity;

import java.util.HashSet;
import java.util.Set;

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
@Table(name="cursuri")
public class Cursuri {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cursID;

	@Column(name = "denumire")
	private String denumire;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST }, 
			targetEntity = Student.class)
	@JoinTable(name = "studcurs",  joinColumns = {
			@JoinColumn(name = "cursuriID") }, 
			inverseJoinColumns = {  @JoinColumn(name = "studID") })
	  private Set<Student> studenti = new HashSet<Student>();;
	
public Cursuri() {}
	
public Cursuri(String denumire) {
	this.denumire = denumire;	
	}
	public Integer getCursID() {
		return cursID;
	}

	public void setCursID(Integer cursID) {
		this.cursID = cursID;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public Set<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(Set<Student> studenti) {
		this.studenti = studenti;
	}

	@Override
	public String toString() {
		return "Cursuri [cursID=" + cursID + ", denumire=" + denumire + ", studenti=" + studenti + "]";
	}
	
	
	
}
