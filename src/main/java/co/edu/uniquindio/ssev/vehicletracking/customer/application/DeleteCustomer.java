package co.edu.uniquindio.ssev.vehicletracking.customer.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.ssev.vehicletracking.customer.domain.repository.CustomerRepository;

@Service
public class DeleteCustomer {

	@Autowired
	private CustomerRepository customerRepository;
	
	public void delete(Long id) {
		
		customerRepository.delete(id);
		
	}
}
