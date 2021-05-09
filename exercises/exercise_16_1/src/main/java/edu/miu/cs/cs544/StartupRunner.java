package edu.miu.cs.cs544;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import edu.miu.cs.cs544.domain.Customer;

import edu.miu.cs.cs544.repository.CustomerRepository;

@Component
public class StartupRunner implements CommandLineRunner {
	
	
	@Autowired
	private CustomerRepository customerRepository;

	
    @Override
    @Transactional
    public void run(String...args) throws Exception {
    	
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	
    
    	Customer cu1 = new Customer("bruke","abebe", sdf.parse("1992-07-26"),"bruke@gmail.com");
    	Customer cu2 = new Customer("alex", "hailu", sdf.parse("1992-07-26"),"alexhailu@gmail.com");
    	Customer cu3 = new Customer("sol", "Moges", sdf.parse("2020-07-26"),"solmoges@gmail.com");
    	customerRepository.save(cu1);
    	customerRepository.save(cu2);
    	customerRepository.save(cu3);
    }
    }

