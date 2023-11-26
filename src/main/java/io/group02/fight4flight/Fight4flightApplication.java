package io.group02.fight4flight;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.group02.fight4flight.customer.Customer;


@SpringBootApplication
@RestController
public class Fight4flightApplication {

	public static void main(String[] args) {
		SpringApplication.run(Fight4flightApplication.class, args);
	}

	@GetMapping
	public List<Customer> hello() {
		return List.of(new Customer("Tomas", "Commit", "tomc@git.com", 1L));
	}

}
