package com.example1.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional

public class Placementservice {
	
	@Autowired
	private PlacementRepository repo;
	
	public Placement get(Long placement_id)
	{
			return repo.findById(placement_id).get();
	}
	public void save(Placement p)
	{
		repo.save(p);		
	}
	public void delete(Long placement_id)
	{
		repo.deleteById(placement_id);
	}
	public List<Placement> listAll()
	{
		return repo.findAll();
	}

}
