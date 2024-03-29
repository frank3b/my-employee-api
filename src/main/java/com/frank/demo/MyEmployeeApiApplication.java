package com.frank.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.convert.Jsr310Converters;

@SpringBootApplication
@EntityScan(basePackageClasses = { MyEmployeeApiApplication.class, Jsr310Converters.class })
public class MyEmployeeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyEmployeeApiApplication.class, args);
	}

}
