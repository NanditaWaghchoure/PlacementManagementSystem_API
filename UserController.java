package com.example1.demo;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
	
	@Autowired
	private  Userservice service;
	
	
	//http://localhost:8080/students -> own method -> listAll()
	@GetMapping("/user") //HTTP request GET, POST, PUT, DELETE
	public List< User> list()
	{
		return service.listAll();
	}
		
	//	http://localhost:8080/students/1 -> get(1) 
	@GetMapping("/ User/{id}")
	public ResponseEntity<User> get(@PathVariable Long user_id)
	{
		try
		{
			User u=service.get(user_id);
			return new  ResponseEntity<User>(u,HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new  ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	
	//, delete(1)
	@DeleteMapping("/User/{id}")
	public void delete(@PathVariable Long user_id)
	{
		service.delete(user_id);
	}

	//http://localhost:8080/students -> post request save()
	@PostMapping("/user")
	public void add(@RequestBody User user)
	{
		service.save(user);
	}

	@PutMapping("/ user/{id}")
	public ResponseEntity< User> update(@RequestBody User user, @PathVariable  Long user_id)
	{
		try
		{
			User u=service.get(user_id);
			service.save(user);
			return new  ResponseEntity< User>(u,HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new  ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}

}
