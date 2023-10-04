package com.example1.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class StudenService {

	@Autowired
	private StudentRepository repo;
	
	public Student get(Long student_id)
	{
			return repo.findById(student_id).get();
	}
	public void save(Student s)
	{
		repo.save(s);		
	}
	public void delete(Long student_id)
	{
		repo.deleteById(student_id);
	}
	public List<Student> listAll()
	{
		return repo.findAll();
	}

}
