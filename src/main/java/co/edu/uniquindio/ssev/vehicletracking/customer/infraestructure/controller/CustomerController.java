package co.edu.uniquindio.ssev.vehicletracking.customer.infraestructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniquindio.ssev.vehicletracking.customer.application.CreateCustomer;
import co.edu.uniquindio.ssev.vehicletracking.customer.application.DeleteCustomer;
import co.edu.uniquindio.ssev.vehicletracking.customer.application.GetCustomer;
import co.edu.uniquindio.ssev.vehicletracking.customer.application.UpdateCustomer;
import co.edu.uniquindio.ssev.vehicletracking.customer.domain.Customer;
import co.edu.uniquindio.ssev.vehicletracking.customer.domain.exception.CustomerCantBeDeletedException;
import co.edu.uniquindio.ssev.vehicletracking.customer.domain.exception.CustomerNotFoundException;

@RestController
@RequestMapping("/customer")
@CrossOrigin("*")
public class CustomerController {
	
	@Autowired
	private CreateCustomer createCustomer;
	
	@Autowired
	private UpdateCustomer updateCustomer;
	
	@Autowired
	private DeleteCustomer deleteCustomer;
	
	@Autowired
	private GetCustomer getCustomer;
	
	@PostMapping
	public ResponseEntity<Customer> create(@RequestBody Customer customer) {
		
		return ResponseEntity.ok(createCustomer.create(customer));
	}
	
	@PatchMapping
	public ResponseEntity<Object> update(@RequestBody Customer customer){
		
		try {
			return ResponseEntity.ok(updateCustomer.update(customer));
		} catch (CustomerNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		
		try {
			deleteCustomer.delete(id);
			return ResponseEntity.ok("El cliente ha sido eliminado");
		} catch (CustomerCantBeDeletedException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
		}
		
	}
	
	
	@GetMapping
	public List<Customer> get(){
		return getCustomer.get();
	}
	
}
