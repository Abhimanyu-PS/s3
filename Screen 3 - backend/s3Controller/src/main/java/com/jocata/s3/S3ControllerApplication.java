package com.jocata.s3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.jocata.s3")
@EntityScan(basePackages = "com.jocata.s3.entity")
public class S3ControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(S3ControllerApplication.class, args);
	}

}
