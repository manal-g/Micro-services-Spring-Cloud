package com.sid.manal.inventoryservice;

import com.sid.manal.inventoryservice.entities.Product;
import com.sid.manal.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration)
	{
		return args -> {
			restConfiguration.exposeIdsFor(Product.class);

			productRepository.saveAll(
					List.of(
							Product.builder().name("Computer").quantity(10).price(8000).build(),
							Product.builder().name("Printer").quantity(18).price(5000).build(),
							Product.builder().name("TV").quantity(20).price(18000).build()


					)
			);

		};
	}

}
