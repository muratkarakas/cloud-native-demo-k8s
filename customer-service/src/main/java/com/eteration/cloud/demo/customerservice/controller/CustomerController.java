package com.eteration.cloud.demo.customerservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eteration.cloud.demo.customerservice.dto.CustomerDTO;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/{id}")
	public CustomerDTO readCustomer(@PathVariable("id") long customerId) {
		
		
		try {
			Thread.sleep((long) (Math.random()*2000));
		} catch (InterruptedException e) {
			logger.error("Sleep error",e);
		}
		
		CustomerDTO customer = new CustomerDTO();
		customer.setId(customerId);
		customer.setName("Murat");
		customer.setSurname("Karakas");
		customer.setAddress("Istanbul/Bahcelievler");
		logger.info("Returning customer : {}",customerId);
		return customer;
	}

}
