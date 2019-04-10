package com.eteration.cloud.demo.orderservice.service;

import java.util.Date;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eteration.cloud.demo.orderservice.client.CustomerServiceClient;
import com.eteration.cloud.demo.orderservice.client.ProductServiceClient;
import com.eteration.cloud.demo.orderservice.dto.CustomerDTO;
import com.eteration.cloud.demo.orderservice.dto.OrderDTO;
import com.eteration.cloud.demo.orderservice.dto.OrderResult;
import com.eteration.cloud.demo.orderservice.dto.ProductDTO;
import com.eteration.cloud.demo.orderservice.dto.RatingEventDTO;

@Service
public class OrderService {
	

	
	@Autowired
	private ProductServiceClient productServiceClient; 
	
	@Autowired
	private CustomerServiceClient customerServiceClient; 
	
	@Autowired
	private RatingEventDispatcher ratingEventDispatcher; 
	
	public OrderResult createOrder(OrderDTO order) throws InterruptedException, ExecutionException {
		OrderResult or = new OrderResult();
		ProductDTO productDTO = productServiceClient.readProductById(order.getProductId());
		CustomerDTO customerDTO = customerServiceClient.readCustomerById(order.getCustomerId());
		
		
		or.setMessage("Dear customer "+customerDTO.getName() +" "+customerDTO.getSurname() +" your order "+productDTO.getName()+" is send to your address: "+customerDTO.getAddress());
		
		double unitPrice = productDTO.getPrice();
		or.setTotalAmount(unitPrice*order.getCount());
		
		
		RatingEventDTO ratingEvent = new RatingEventDTO();
		ratingEvent.setCustomerId(order.getCustomerId());
		ratingEvent.setProductId(order.getProductId());
		ratingEvent.setOperationType("Order.Created");
		ratingEvent.setOperationDate(new Date());
		ratingEventDispatcher.dispatch(ratingEvent );
		return or;
	}

}
