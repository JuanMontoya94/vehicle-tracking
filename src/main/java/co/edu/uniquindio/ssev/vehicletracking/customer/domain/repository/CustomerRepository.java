package co.edu.uniquindio.ssev.vehicletracking.customer.domain.repository;

import java.util.List;

import co.edu.uniquindio.ssev.vehicletracking.customer.domain.Customer;

public interface CustomerRepository {
	
	public Customer save(Customer customer);
	
	public boolean exists(Long id);
	
	public void delete(Long id);
	
	public Customer findCustomer(Long id);
	
	public List<Customer> get();

}
