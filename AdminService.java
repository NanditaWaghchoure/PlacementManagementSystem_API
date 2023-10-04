package com.example1.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class AdminService {

	@Autowired
	private AdminRepository repo;
	
	public Admin get(Integer admin_id)
	{
			return repo.findById(admin_id).get();
	}
	public void save(Admin a)
	{
		repo.save(a);		
	}
	public void delete(Integer admin_id)
	{
		repo.deleteById(admin_id);
	}
	public List<Admin> listAll()
	{
		return repo.findAll();
	}

}
