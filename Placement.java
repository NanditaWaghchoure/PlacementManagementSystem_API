package com.example1.demo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.relational.core.mapping.Table;


@Entity
@Table(name="Placement")
public class Placement {
	
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	@Column(name="placement_id")
	private long placement_id;
	
	@Column(name="placementname")
	private String placementname;
	
	@Column(name="Date")
	private Date LocalDate;
	
	@Column(name=" qualification")
	private String qualification;
	
	@Column(name="year")
	private int year;
	
	//Mapping placement to college
	@ManyToOne()
	@JoinColumn(name="college_id")
	private College college;

	public Placement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Placement(long placement_id, String placementname, Date localDate, String qualification, int year,
			College college) {
		super();
		this.placement_id = placement_id;
		this.placementname = placementname;
		LocalDate = localDate;
		this.qualification = qualification;
		this.year = year;
		this.college = college;
	}

	public long getPlacement_id() {
		return placement_id;
	}

	public void setPlacement_id(long placement_id) {
		this.placement_id = placement_id;
	}

	public String getPlacementname() {
		return placementname;
	}

	public void setPlacementname(String placementname) {
		this.placementname = placementname;
	}

	public Date getLocalDate() {
		return LocalDate;
	}

	public void setLocalDate(Date localDate) {
		LocalDate = localDate;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
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
