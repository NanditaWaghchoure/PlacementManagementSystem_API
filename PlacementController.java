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

public class PlacementController {
	
	@Autowired
	private  Placementservice service;
	
	
	//http://localhost:8080/students -> own method -> listAll()
	@GetMapping("/placement") //HTTP request GET, POST, PUT, DELETE
	public List< Placement> list()
	{
		return service.listAll();
	}
		
	//	http://localhost:8080/students/1 -> get(1) 
	@GetMapping("/Placement/{id}")
	public ResponseEntity<Placement> get(@PathVariable Long  placement_id)
	{
		try
		{
			 Placement p=service.get( placement_id);
			return new  ResponseEntity<Placement>(p,HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new  ResponseEntity<Placement>(HttpStatus.NOT_FOUND);
		}
	}
	
	//, delete(1)
	@DeleteMapping("/placement/{id}")
	public void delete(@PathVariable Long  placement_id)
	{
		service.delete( placement_id);
	}

	//http://localhost:8080/students -> post request save()
	@PostMapping("/placement")
	public void add(@RequestBody Placement placement)
	{
		service.save(placement);
	}

	@PutMapping("/ placement/{id}")
	public ResponseEntity< Placement> update(@RequestBody Placement placement, @PathVariable   Long placement_id)
	{
		try
		{
			Placement p=service.get( placement_id);
			service.save(placement);
			return new  ResponseEntity< Placement>(p,HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new  ResponseEntity< Placement>(HttpStatus.NOT_FOUND);
		}
	}


}


