package com.company.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.company.constant.Constant;

@Configuration
public class UserServiceConfig {
	
	@Bean
	NewTopic topic() {
		
		/*
		 * return TopicBuilder.name(Constant.TOPIC_NAME) //.partitions(0) //.replicas(0)
		 * .build();
		 */
		return new NewTopic(Constant.TOPIC_NAME, 5, (short) 1);
	}

}
