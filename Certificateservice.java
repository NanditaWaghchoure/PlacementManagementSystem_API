package com.example1.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class Certificateservice 
{
	@Autowired
	private CertificateRepository repo;
	
	public  Certificate get(Long cc_id)
	{
			return repo.findById(cc_id).get();
	}
	public void save(Certificate cc)
	{
		repo.save(cc);		
	}
	public void delete(Long cc_id)
	{
		repo.deleteById(cc_id);
	}
	public List<Certificate> listAll()
	{
		return repo.findAll();
	}

}
