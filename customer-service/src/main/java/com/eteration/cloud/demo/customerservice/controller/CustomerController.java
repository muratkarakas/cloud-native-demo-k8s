package com.eteration.cloud.demo.customerservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eteration.cloud.demo.customerservice.dto.CustomerDTO;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/{id}")
	public CustomerDTO readCustomer(@PathVariable("id") long customerId) {
		CustomerDTO customer = new CustomerDTO();
		customer.setId(customerId);
		customer.setName("Murat");
		customer.setSurname("Karakas");
		customer.setAddress("Istanbul/Bahcelievler");
		logger.info("Returning customer : {}",customerId);
		return customer;
	}

}
