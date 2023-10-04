package com.example1.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class CollegeService {
	

	@Autowired
	private CollegeRepository repo;
	
	public College get(Long college_id)
	{
			return repo.findById( college_id).get();
	}
	public void save(College c)
	{
		repo.save(c);		
	}
	public void delete(Long college_id)
	{
		repo.deleteById(college_id);
	}
	public List<College> listAll()
	{
		return repo.findAll();
	}

}
