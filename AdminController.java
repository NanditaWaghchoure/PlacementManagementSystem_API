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
public class AdminController {
	
	@Autowired
	private  AdminService service;
	
	
	//http://localhost:8080/students -> own method -> listAll()
	@GetMapping("/admin") //HTTP request GET, POST, PUT, DELETE
	public List< Admin> list()
	{
		return service.listAll();
	}
		
	//	http://localhost:8080/students/1 -> get(1) 
	@GetMapping("/ Admin/{id}")
	public ResponseEntity<Admin> get(@PathVariable Integer admin_id)
	{
		try
		{
			Admin a=service.get(admin_id);
			return new  ResponseEntity<Admin>(a,HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new  ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}
	}
	
	//, delete(1)
	@DeleteMapping("/Admin/{id}")
	public void delete(@PathVariable Integer admin_id)
	{
		service.delete(admin_id);
	}

	//http://localhost:8080/students -> post request save()
	@PostMapping("/admin")
	public void add(@RequestBody Admin admin)
	{
		service.save(admin);
	}

	@PutMapping("/ admin/{id}")
	public ResponseEntity<Admin> update(@RequestBody Admin admin, @PathVariable Integer admin_id )
	{
		try
		{
			Admin a=service.get(admin_id);
			service.save(admin);
			return new  ResponseEntity<Admin>(a,HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new  ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}
	}



}



