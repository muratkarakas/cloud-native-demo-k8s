package com.eteration.cloud.demo.productservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eteration.cloud.demo.productservice.dto.ProductDTO;

@RestController
@RequestMapping("/products")
public class ProductController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	

	@RequestMapping("/{id}")
	public ProductDTO readProduct(@PathVariable("id") long productId) {
		ProductDTO p = new ProductDTO();
		double  productBasePrice = 50;
		p.setId(productId);
		p.setName("Product" + productId);
		p.setPrice(productBasePrice + (productBasePrice*18/100));
		logger.info("Returning product : {}", productId);

		return p;
	}
	


}
