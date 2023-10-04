package com.example1.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Userservice {
	
	@Autowired
	private UserRepository repo;
	
	public User get(Long user_id)
	{
			return repo.findById(user_id).get();
	}
	public void save(User u)
	{
		repo.save(u);		
	}
	public void delete(Long user_id)
	{
		repo.deleteById(user_id);
	}
	public List<User> listAll()
	{
		return repo.findAll();
	}

}
