package com.eteration.cloud.demo.orderservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.eteration.cloud.demo.orderservice.dto.CustomerDTO;

@Component
public class CustomerServiceClient {
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@Value("${client.customerservice.path}")
	String customerServicePath;
	
	public CustomerDTO readCustomerById(long customerId) {
		return restTemplate.getForObject(customerServicePath+"/customers/"+customerId, CustomerDTO.class);
	}
	
}
