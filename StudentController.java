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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudenService service;
	
	
	//http://localhost:8080/students -> own method -> listAll()
	@GetMapping  //HTTP request GET, POST, PUT, DELETE
	public List<Student> list()
	{
		return service.listAll();
	}
		
	//	http://localhost:8080/students/1 -> get(1) 
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> get(@PathVariable Long student_id)
	{
		try
		{
			Student s=service.get(student_id);
			return new  ResponseEntity<Student>(s,HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new  ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}
	
	//, delete(1)
	@DeleteMapping("/students/{id}")
	public void delete(@PathVariable Long student_id)
	{
		service.delete(student_id);
	}

	//http://localhost:8080/students -> post request save()
	@PostMapping("/students")
	public void add(@RequestBody Student student)
	{
		service.save(student);
	}

	@PutMapping("/students/{id}")
	public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable Long student_id)
	{
		try
		{
			Student s=service.get(student_id);
			service.save(student);
			return new  ResponseEntity<Student>(s,HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new  ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}


}
