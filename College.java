package com.example1.demo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.data.relational.core.mapping.Table;


@Entity
@Table(name="College")
public class College {
	
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="college_id")	
	private long college_id;
	
	@Column(name="college_name")	
	private String college_name;
	
	@Column(name="location")	
	private String location;
	

	//Mapping college to certificate
	@OneToMany(mappedBy="college")
	private Set<Certificate>certificate;

	
	//Mapping college to student
		@OneToMany(mappedBy="college")
		private Set<Student> student;
		

		//Mapping college to placement
		@OneToMany(mappedBy="college")
		private Set<Placement> placement;
		
		//Mapping college to user
		@OneToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="user_id")
		private User collegeAdmin;

		public College() {
			super();
			// TODO Auto-generated constructor stub
		}

		public College(long college_id, String college_name, String location, Set<Certificate> certificate,
				Set<Student> student, Set<Placement> placement, com.example1.demo.User collegeAdmin) {
			super();
			this.college_id = college_id;
			this.college_name = college_name;
			this.location = location;
			this.certificate = certificate;
			this.student = student;
			this.placement = placement;
			this.collegeAdmin = collegeAdmin;
		}

		public long getCollege_id() {
			return college_id;
		}

		public void setCollege_id(long college_id) {
			this.college_id = college_id;
		}

		public String getCollege_name() {
			return college_name;
		}

		public void setCollege_name(String college_name) {
			this.college_name = college_name;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public Set<Certificate> getCertificate() {
			return certificate;
		}

		public void setCertificate(Set<Certificate> certificate) {
			this.certificate = certificate;
		}

		public Set<Student> getStudent() {
			return student;
		}

		public void setStudent(Set<Student> student) {
			this.student = student;
		}

		public Set<Placement> getPlacement() {
			return placement;
		}

		public void setPlacement(Set<Placement> placement) {
			this.placement = placement;
		}

		public User getCollegeAdmin() {
			return collegeAdmin;
		}

		public void setCollegeAdmin(User collegeAdmin) {
			this.collegeAdmin = collegeAdmin;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}


		

		
		


	
	
}
