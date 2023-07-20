package com.kn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication  // same
public class ProductServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApp.class, args);
	}
}
