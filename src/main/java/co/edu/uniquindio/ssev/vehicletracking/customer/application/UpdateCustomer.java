package co.edu.uniquindio.ssev.vehicletracking.customer.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.ssev.vehicletracking.customer.domain.Customer;
import co.edu.uniquindio.ssev.vehicletracking.customer.domain.exception.CustomerNotFoundException;
import co.edu.uniquindio.ssev.vehicletracking.customer.domain.repository.CustomerRepository;

@Service
public class UpdateCustomer {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer update(Customer customer) {
		
		if(customerRepository.exists(customer.getId())) {
			return customerRepository.save(customer);
		}
		throw new CustomerNotFoundException("Cliente con id "+customer.getId()+" no existe!");
		
	}
	
}
