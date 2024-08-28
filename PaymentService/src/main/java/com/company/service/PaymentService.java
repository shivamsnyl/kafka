package com.company.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.company.constant.Constant;
import com.company.dto.Customer;

@Service
public class PaymentService {
	
	@KafkaListener(topics = Constant.TOPIC_NAME, groupId = "group-1")
	void consumeMessage1(String message) {
		System.out.println("Message 1 for Location :: "+ message);
	}
	
	@KafkaListener(topics = Constant.CUSTOMER_NAME, groupId = "group-2")
	void consumeCustomer(Customer c) {
		System.out.println("Customer object received :: "+ c);
	}
	
	/*
	 * @KafkaListener(topics = Constant.TOPIC_NAME, groupId = "group-1") void
	 * consumeMessage2(String message) {
	 * System.out.println("Message 2 for Location :: "+ message); }
	 * 
	 * @KafkaListener(topics = Constant.TOPIC_NAME, groupId = "group-1") void
	 * consumeMessage3(String message) {
	 * System.out.println("Message 3 for Location :: "+ message); }
	 * 
	 * @KafkaListener(topics = Constant.TOPIC_NAME, groupId = "group-1") void
	 * consumeMessage4(String message) {
	 * System.out.println("Message 4 for Location :: "+ message); }
	 */
}