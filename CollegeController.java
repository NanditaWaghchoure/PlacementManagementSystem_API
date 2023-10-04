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
public class CollegeController {
	
	@Autowired
	private CollegeService service;
	
	
	//http://localhost:8080/students -> own method -> listAll()
	@GetMapping("/college") //HTTP request GET, POST, PUT, DELETE
	public List<College> list()
	{
		return service.listAll();
	}
		
	//	http://localhost:8080/students/1 -> get(1) 
	@GetMapping("/College/{id}")
	public ResponseEntity<College> get(@PathVariable Long college_id)
	{
		try
		{
			College c=service.get(college_id);
			return new  ResponseEntity<College>(c,HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new  ResponseEntity<College>(HttpStatus.NOT_FOUND);
		}
	}
	
	//, delete(1)
	@DeleteMapping("/college/{id}")
	public void delete(@PathVariable Long college_id)
	{
		service.delete(college_id);
	}

	//http://localhost:8080/students -> post request save()
	@PostMapping("/college")
	public void add(@RequestBody College college)
	{
		service.save(college);
	}

	@PutMapping("/college/{id}")
	public ResponseEntity<College> update(@RequestBody College college, @PathVariable  Long college_id )
	{
		try
		{
			College c=service.get(college_id);
			service.save(college);
			return new  ResponseEntity<College>(c,HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new  ResponseEntity<College>(HttpStatus.NOT_FOUND);
		}
	}

}
