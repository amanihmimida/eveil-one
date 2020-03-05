package com.upem.iot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;



@CrossOrigin("*")
@EntityScan( basePackages = {"com.upem.models"} )
@ComponentScan( basePackages = {"com.upem.controller"} )
@EnableJpaRepositories("com.upem.repository")
@SpringBootApplication
public class IotIpiApplication {

	public static void main(String[] args) {
		SpringApplication.run(IotIpiApplication.class, args);
	}

}
