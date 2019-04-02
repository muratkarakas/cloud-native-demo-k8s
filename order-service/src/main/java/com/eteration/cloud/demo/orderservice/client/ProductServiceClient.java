package com.eteration.cloud.demo.orderservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.eteration.cloud.demo.orderservice.dto.ProductDTO;

@Component
public class ProductServiceClient {
	
	
	@Value("${client.productservice.path}")
	String productServicePath;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	public ProductDTO readProductById(long productId) {
		return restTemplate.getForObject(productServicePath+"/products/"+productId, ProductDTO.class);
	}
	
	
	
}
