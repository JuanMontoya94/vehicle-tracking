package co.edu.uniquindio.ssev.vehicletracking.customer.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniquindio.ssev.vehicletracking.customer.application.CreateCustomer;
import co.edu.uniquindio.ssev.vehicletracking.customer.application.DeleteCustomer;
import co.edu.uniquindio.ssev.vehicletracking.customer.application.UpdateCustomer;
import co.edu.uniquindio.ssev.vehicletracking.customer.domain.Customer;
import co.edu.uniquindio.ssev.vehicletracking.customer.domain.exception.CustomerNotFoundException;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CreateCustomer createCustomer;
	
	@Autowired
	private UpdateCustomer updateCustomer;
	
	@Autowired
	private DeleteCustomer deleteCustomer;
	
	@PostMapping
	public ResponseEntity<Customer> create(@RequestBody Customer customer) {
		
		return ResponseEntity.ok(createCustomer.create(customer));
	}
	
	@PutMapping
	public ResponseEntity<Customer> update (@RequestBody Customer customer){
		
		try {
			return ResponseEntity.ok(updateCustomer.update(customer));
		} catch (CustomerNotFoundException c) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	
	@DeleteMapping
	public ResponseEntity<Customer> delete(@RequestBody Long id){
		
		try {
			return ResponseEntity.ok(deleteCustomer.delete(id));
		} catch (CustomerNotFoundException c) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
 	
}
