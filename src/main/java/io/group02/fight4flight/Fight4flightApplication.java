package io.group02.fight4flight;

import java.util.*;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.group02.fight4flight.domain.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@SpringBootApplication
@RestController
public class Fight4flightApplication {

	@PersistenceContext
	private EntityManager entityManager;

	public static void main(String[] args) {
		SpringApplication.run(Fight4flightApplication.class, args);
	}

	// @GetMapping
	// @Transactional
	// public List<Customer> hello() {
	// 	if (!isTableExists("Customer")) {
	// 		System.out.println("Table not found");
	// 		return List.of(); // Table doesn't exist, return an empty list
	// 	}

	// 	Customer newCustomer = new Customer("Teler", "Juston", "jtl@git.com");
	// 	entityManager.persist(newCustomer);

	// 	// Fetch all customers from the database
	// 	TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Customer c", Customer.class);
	// 	return query.getResultList();
	// }

	private boolean isTableExists(String tableName) {
		jakarta.persistence.Query query = entityManager.createNativeQuery(
				"SELECT 1 FROM information_schema.tables WHERE table_name = :tableName");
		query.setParameter("tableName", tableName);
		return query.getResultList().size() > 0;
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") // Apply to all endpoints
						.allowedOrigins("http://localhost:3000") // Allow this origin
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow these HTTP methods
						.allowedHeaders("*") // Allow all headers
						.allowCredentials(true); // Allow credentials
			}
		};
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/customers")
	@Transactional
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		entityManager.persist(customer);
		return ResponseEntity.ok(customer);
	}

}
