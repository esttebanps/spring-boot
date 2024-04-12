package com.example.demo;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringWebMvcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringWebMvcApplication.class, args);
		var repository = context.getBean(ProductRepository.class);
		List<Product> products = List.of(
				new Product(null,"primer producto",5.55,12),
				new Product(null,"producto salud",12.3,63),
				new Product(null,"comida producto",2.45,5),
				new Product(null,"otros varios",8.48,84)
		);
		repository.saveAll(products);
	}
}
