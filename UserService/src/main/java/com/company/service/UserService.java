package com.company.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.company.constant.Constant;
import com.company.dto.Customer;

@Service
public class UserService {

	@Autowired
	KafkaTemplate<String, Object> kafkaTemplate;
	
	public boolean updateLocation(String location) {
		
		
		CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(Constant.TOPIC_NAME,location);
		
		future.whenComplete((result,ex)->{
			
			if(ex==null) {
				System.out.println("Sent Message with location" + location + "with offset = "
						+ result.getRecordMetadata().offset());
			}
			else {
				System.out.println("unable to update location" + location + "due to :: "
						+ ex.getMessage());
			}
			
		});
		
		return true;
	}
	
	
	public boolean customerSend(Customer c) {
		
		
		try {
			CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(Constant.CUSTOMER_NAME,c);
			
			future.whenComplete((result,ex)->{
				
				if(ex==null) {
					System.out.println("Sent Customer Object" + c + "with offset = "
							+ result.getRecordMetadata().offset());
				}
				else {
					System.out.println("unable to send customer" + c + "due to :: "
							+ ex.getMessage());
				}
				
			});
		} catch (Exception e) {
			System.out.println("Exception occured while sending customer object i.e, :::" + e.getMessage());
		}
		
		return true;
	}
	
}
