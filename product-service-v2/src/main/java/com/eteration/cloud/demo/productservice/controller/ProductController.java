package com.eteration.cloud.demo.productservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eteration.cloud.demo.productservice.dto.ProductDTO;

@RestController
@RequestMapping("/products")
public class ProductController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	

	@GetMapping("/{id}")
	public ProductDTO readProduct(@PathVariable("id") long productId) {
		

		try {
			Thread.sleep((long) (Math.random()*2000));
		} catch (InterruptedException e) {
			logger.error("Sleep error",e);
		}
		
		ProductDTO p = new ProductDTO();
		double  productBasePrice = 50;
		p.setId(productId);
		p.setName("V2-Product" + productId);
		p.setPrice(productBasePrice + (productBasePrice*18/100));
		logger.info("Returning product : {}", productId);

		return p;
	}
	


}
