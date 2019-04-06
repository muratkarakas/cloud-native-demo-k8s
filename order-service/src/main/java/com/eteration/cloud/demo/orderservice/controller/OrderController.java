package com.eteration.cloud.demo.orderservice.controller;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eteration.cloud.demo.orderservice.dto.OrderDTO;
import com.eteration.cloud.demo.orderservice.dto.OrderResult;
import com.eteration.cloud.demo.orderservice.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private OrderService orderService;
	

	
	
	@PostMapping
	public OrderResult createOrder(@RequestBody OrderDTO order) throws InterruptedException, ExecutionException  {
		logger.info("Received order create request : {}",order);
		OrderResult or = orderService.createOrder(order);
		logger.info("Created order : {}",or);
		return or;
	}


	//@Scheduled(fixedRate = 60000)
	public void creteSampleOrder() throws InterruptedException, ExecutionException {
		logger.info("Scheduled sample order creation start");
		OrderDTO dto = new OrderDTO();
		
		dto.setCount(3);
		dto.setCustomerId(5);
		dto.setProductId(5);
		
		createOrder(dto);
		
		logger.info("Scheduled sample order creation done");
	}

}
