package co.edu.uniquindio.ssev.vehicletracking.customer.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.ssev.vehicletracking.customer.domain.Customer;
import co.edu.uniquindio.ssev.vehicletracking.customer.domain.repository.CustomerRepository;

@Service
public class GetCustomer {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> get() {
		return customerRepository.get();
	}

}
