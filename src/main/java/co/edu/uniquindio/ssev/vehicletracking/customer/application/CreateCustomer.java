package co.edu.uniquindio.ssev.vehicletracking.customer.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.ssev.vehicletracking.customer.domain.Customer;
import co.edu.uniquindio.ssev.vehicletracking.customer.domain.repository.CustomerRepository;

@Service
public class CreateCustomer {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer create(Customer customer) {
		return customerRepository.create(customer);
	}

}
