package com.kn.product.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(scanBasePackages = { "com.kn.product" },exclude=HibernateJpaAutoConfiguration.class)   // same
	
//, exclude = HibernateJpaAu toConfiguration.class)// as
// @Configuration
// @EnableAutoiguration
// @ComponentScan
// combined
public class ProductServiceApp {

	public static void main(String[] args) {
		System.getProperties().put("server.port", 8189);
		SpringApplication.run(ProductServiceApp.class, args);
	}
}
