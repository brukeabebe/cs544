package edu.miu.cs.cs544.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.domain.CountryRegion;
import edu.miu.cs.cs544.repository.CountryRepository;

@RestController
@RequestMapping("/countries")
public class CountryController {
	
	@Autowired
	private CountryRepository countryRepository;
	
	@GetMapping
	public List<CountryRegion> findAll() {
		return countryRepository.findAll();
	}
	
	@GetMapping(params = "paged=true")
	public Page<CountryRegion> findAll(Pageable pageable) {
		return countryRepository.findAll(pageable);
	}
	
}
