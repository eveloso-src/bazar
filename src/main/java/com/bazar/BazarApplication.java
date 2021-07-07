package com.bazar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bazar.model.Product;
import com.bazar.repository.ProductRepository;

@SpringBootApplication
public class BazarApplication {

	public static void main(String[] args) {
		SpringApplication.run(BazarApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductRepository productRepository) {
		return (args) -> {
			Product product = new Product();
			product.setDescription("Zapatillas Reebok rojas 43");
			product.setId(1);
			product.setPrice(1234.56);
			product.setStatus(1);
			product.setTitle("Zapatillas Reebook");
			productRepository.save(product);

			product = new Product();
			product.setDescription("Buzo Adidas M con cierre");
			product.setId(2);
			product.setPrice(124.56);
			product.setStatus(1);
			product.setTitle("Zapatillas Reebook");
			productRepository.save(product);

			product = new Product();
			product.setDescription("Medias Adidas color negro");
			product.setId(3);
			product.setPrice(12.56);
			product.setStatus(1);
			product.setTitle("Medias negras");
			productRepository.save(product);

			product = new Product();
			product.setDescription("Medias futbol color blanco");
			product.setId(4);
			product.setPrice(12.56);
			product.setStatus(1);
			product.setTitle("Medias futbol");
			productRepository.save(product);

			product = new Product();
			product.setDescription("Campera gimnasia con ciere");
			product.setId(5);
			product.setPrice(1233.56);
			product.setStatus(1);
			product.setTitle("Campera gimnasia");
			productRepository.save(product);
		};
	}
}
