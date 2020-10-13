package com.qa.dnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DnDBackendApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DnDBackendApplication.class, args);
	}

}
