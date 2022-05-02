package co.edu.uniquindio.ssev.vehicletracking.customer.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniquindio.ssev.vehicletracking.customer.application.CreateCustomer;
import co.edu.uniquindio.ssev.vehicletracking.customer.domain.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CreateCustomer createCustomer;
	
	@PostMapping
	public ResponseEntity<Customer> create(@RequestBody Customer customer) {
		
		return ResponseEntity.ok(createCustomer.create(customer));
	}
	
}
