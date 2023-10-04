package com.example1.demo;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name="Certificate")
public class Certificate {
	
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="cc_id")
	private long cc_id;
	
	@Column(name="year")
	private int year;
	
	//Mapping certificate to student
	
	@OneToOne(mappedBy="certificate",cascade=CascadeType.ALL)
	private Student student;

	

	//Mapping certificate to college
	@ManyToOne()
	@JoinColumn(name="college_id")
	private College college;



	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Certificate(long cc_id, int year, com.example1.demo.Student student, com.example1.demo.College college) {
		super();
		this.cc_id = cc_id;
		this.year = year;
		this.student = student;
		this.college = college;
	}



	public long getCc_id() {
		return cc_id;
	}



	public void setCc_id(long cc_id) {
		this.cc_id = cc_id;
	}



	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}



	public Student getStudent() {
		return student;
	}



	public void setStudent(Student student) {
		this.student = student;
	}



	public College getCollege() {
		return college;
	}



	public void setCollege(College college) {
		this.college = college;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	}
