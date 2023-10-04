package com.example1.demo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.data.relational.core.mapping.Table;


@Entity        //this annotation specifies that class is an entity
@Table(name="Admin")    //table name can be specified
public class Admin {
	
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name="admin_id")    //define the column names of table
	private int admin_id;
	
	@Column(name="adminname")
	private String adminname;
	
	@Column(name="adminpassword")
	private String adminpassword;
	
	//Mapping Admin to user
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User collegeAdmin;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int admin_id, String adminname, String adminpassword, User collegeAdmin) {
		super();
		this.admin_id = admin_id;
		this.adminname = adminname;
		this.adminpassword = adminpassword;
		this.collegeAdmin = collegeAdmin;
	}

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getAdminpassword() {
		return adminpassword;
	}

	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
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
