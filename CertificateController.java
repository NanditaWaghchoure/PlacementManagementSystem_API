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
public class CertificateController {
	
	@Autowired
	private  Certificateservice service;
	
	
	//http://localhost:8080/students -> own method -> listAll()
	@GetMapping("/certificate") //HTTP request GET, POST, PUT, DELETE
	public List< Certificate> list()
	{
		return service.listAll();
	}
		
	//	http://localhost:8080/students/1 -> get(1) 
	@GetMapping("/ Certificate/{id}")
	public ResponseEntity<Certificate> get(@PathVariable Long cc_id)
	{
		try
		{
			 Certificate cc=service.get(cc_id);
			return new  ResponseEntity<Certificate>(cc,HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new  ResponseEntity<Certificate>(HttpStatus.NOT_FOUND);
		}
	}
	
	//, delete(1)
	@DeleteMapping("/certificate/{id}")
	public void delete(@PathVariable Long cc_id)
	{
		service.delete(cc_id);
	}

	//http://localhost:8080/students -> post request save()
	@PostMapping("/certificate")
	public void add(@RequestBody Certificate certificate)
	{
		service.save(certificate);
	}

	@PutMapping("/ certificate/{id}")
	public ResponseEntity< Certificate> update(@RequestBody Certificate certificate, @PathVariable  Long cc_id)
	{
		try
		{
			 Certificate cc=service.get(cc_id);
			service.save(certificate);
			return new  ResponseEntity< Certificate>(cc,HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new  ResponseEntity< Certificate>(HttpStatus.NOT_FOUND);
		}
	}


}



