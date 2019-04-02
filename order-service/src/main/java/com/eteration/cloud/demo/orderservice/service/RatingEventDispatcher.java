package com.eteration.cloud.demo.orderservice.service;

import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.eteration.cloud.demo.orderservice.dto.RatingEventDTO;

@Service
public class RatingEventDispatcher {

	@Autowired
	private KafkaTemplate<String, RatingEventDTO> ratingKafkaTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(RatingEventDispatcher.class);

	public boolean dispatch(RatingEventDTO ratingEvent) throws InterruptedException, ExecutionException {
			SendResult<String, RatingEventDTO> sendResult = ratingKafkaTemplate.send("orders", ratingEvent).get();
			RecordMetadata recordMetadata = sendResult.getRecordMetadata();
			LOGGER.info("Dispatch event to topic = {}, partition = {}, offset = {}, ratingEvent = {}", recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset(), ratingEvent);
			return true;

	}
}
