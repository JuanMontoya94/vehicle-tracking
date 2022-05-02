package co.edu.uniquindio.ssev.vehicletracking.customer.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<Object> update (@RequestBody Customer customer){
		
		try {
			return ResponseEntity.ok(updateCustomer.update(customer));
		} catch (CustomerNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
		}
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		
		deleteCustomer.delete(id);
		return ResponseEntity.ok("El cliente ha sido eliminado");
	}
	
 	
}
