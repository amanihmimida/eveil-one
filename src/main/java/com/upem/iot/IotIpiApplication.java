package com.upem.iot;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;





@CrossOrigin("*")
@EntityScan( basePackages = {"com.upem.models"} )
@ComponentScan( basePackages = {"com.upem.controller"} )
@ComponentScan( basePackages = {"com.upem.services"} )
@EnableJpaRepositories("com.upem.repository")
@EnableAutoConfiguration
@SpringBootApplication
public class IotIpiApplication {
	
	public static void main(String[] args) {
		
		SpringApplication.run(IotIpiApplication.class, args);
		//TopicSubscriber subscriber = new TopicSubscriber();
		//subscriber.run("tcp://mr2aqty0xnech1.messaging.solace.cloud:20966" , "solace-cloud-client","cljvbkb0l1ineecvafr9863d2o");
		//subscriber.getPayload("lola");
		//subscriber.run();
		
		
	}
	
	

}
