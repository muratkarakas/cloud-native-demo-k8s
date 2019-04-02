package com.eteration.cloud.demo.ratingservice.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import com.eteration.cloud.demo.ratingservice.dto.RatingEventDTO;

@Service
public class OrderEventConsumer {
	private static final Logger log = LoggerFactory.getLogger(OrderEventConsumer.class);

	@KafkaListener(topics = "orders")
	public void onReceiving(RatingEventDTO ratingRecordDTO, @Header(KafkaHeaders.OFFSET) Integer offset, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) throws InterruptedException {
		
		log.info("Receieved Rating Event {}",ratingRecordDTO.getOperationType());
		log.info("Processing topic = {}, partition = {}, offset = {}, RatingEvent = {}", topic, partition, offset, ratingRecordDTO);

		Thread.sleep(10000);
		log.info("Finished Processing Rating Event {}",ratingRecordDTO.getOperationType());
	}
}
