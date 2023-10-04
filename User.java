package com.example1.demo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name="User")
public class User {
	
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name="user_id")
	private long user_id;
	
	
	@Column(name="user_name")
	private String user_name;
	
	
	@Column(name="usertype")
	private String usertype;
	
	@Column(name="userpassword")
	private String userpassword;
	
	//Mapping user to college
		@OneToOne(mappedBy="collegeAdmin",cascade=CascadeType.ALL)
		private College college;
		
		//Mapping user to admin
		@OneToOne(mappedBy="collegeAdmin",cascade=CascadeType.ALL)
		private Admin admin;

		public User() {
			super();
			// TODO Auto-generated constructor stub
		}

		public User(long user_id, String user_name, String usertype, String userpassword, College college,
				com.example1.demo.Admin admin) {
			super();
			this.user_id = user_id;
			this.user_name = user_name;
			this.usertype = usertype;
			this.userpassword = userpassword;
			this.college = college;
			this.admin = admin;
		}

		public long getUser_id() {
			return user_id;
		}

		public void setUser_id(long user_id) {
			this.user_id = user_id;
		}

		public String getUser_name() {
			return user_name;
		}

		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}

		public String getUsertype() {
			return usertype;
		}

		public void setUsertype(String usertype) {
			this.usertype = usertype;
		}

		public String getUserpassword() {
			return userpassword;
		}

		public void setUserpassword(String userpassword) {
			this.userpassword = userpassword;
		}

		public College getCollege() {
			return college;
		}

		public void setCollege(College college) {
			this.college = college;
		}

		public Admin getAdmin() {
			return admin;
		}

		public void setAdmin(Admin admin) {
			this.admin = admin;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		
}
