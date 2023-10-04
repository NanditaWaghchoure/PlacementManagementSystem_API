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
@Table(name="Studentsdetails")

public class Student {
	
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="student_id")	
	private long student_id;

	@Column(name="student_name")
	private String student_name;

	@Column(name="student_roll")
	private long student_roll;

	@Column(name="studentquali")
	private String studentquali;

	@Column(name="student_course")
	private String student_course;

	@Column(name="studentyear")
	private int studentyear;

	@Column(name="student_hallticketno")
	private long student_hallticketno;
	
	

	//Mapping Student to college

	@ManyToOne()
	@JoinColumn(name="college_id")
	private College college;
	
	//Mapping Student to Certificate
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cc_id")
	private Certificate certificate;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(long student_id, String student_name, long student_roll, String studentquali, String student_course,
			int studentyear, long student_hallticketno, com.example1.demo.College college,
			com.example1.demo.Certificate certificate) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_roll = student_roll;
		this.studentquali = studentquali;
		this.student_course = student_course;
		this.studentyear = studentyear;
		this.student_hallticketno = student_hallticketno;
		this.college = college;
		this.certificate = certificate;
	}

	public long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(long student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public long getStudent_roll() {
		return student_roll;
	}

	public void setStudent_roll(long student_roll) {
		this.student_roll = student_roll;
	}

	public String getStudentquali() {
		return studentquali;
	}

	public void setStudentquali(String studentquali) {
		this.studentquali = studentquali;
	}

	public String getStudent_course() {
		return student_course;
	}

	public void setStudent_course(String student_course) {
		this.student_course = student_course;
	}

	public int getStudentyear() {
		return studentyear;
	}

	public void setStudentyear(int studentyear) {
		this.studentyear = studentyear;
	}

	public long getStudent_hallticketno() {
		return student_hallticketno;
	}

	public void setStudent_hallticketno(long student_hallticketno) {
		this.student_hallticketno = student_hallticketno;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public Certificate getCertificate() {
		return certificate;
	}

	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
