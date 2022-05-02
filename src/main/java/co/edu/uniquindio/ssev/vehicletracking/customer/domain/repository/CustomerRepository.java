package co.edu.uniquindio.ssev.vehicletracking.customer.domain.repository;

import co.edu.uniquindio.ssev.vehicletracking.customer.domain.Customer;

public interface CustomerRepository {
	
	public Customer save(Customer customer);
	
	public boolean exists(Long id);
	
	public void delete(Long id);

}
