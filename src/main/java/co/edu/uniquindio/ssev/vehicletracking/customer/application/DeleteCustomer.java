package co.edu.uniquindio.ssev.vehicletracking.customer.application;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.ssev.vehicletracking.customer.domain.Customer;
import co.edu.uniquindio.ssev.vehicletracking.customer.domain.exception.DeleteCustomerException;
import co.edu.uniquindio.ssev.vehicletracking.customer.domain.repository.CustomerRepository;
import co.edu.uniquindio.ssev.vehicletracking.customer.infraestructure.persistence.entity.CustomerEntity;
import co.edu.uniquindio.ssev.vehicletracking.customer.infraestructure.persistence.repository.CustomerEntityRepository;

@Service
public class DeleteCustomer {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerEntityRepository customerEntityRepository;
	
	public void delete(Long id) {
		
		CustomerEntity customer= customerEntityRepository.findById(id).get();
		if(customer.getVehicles()== null) {
		customerRepository.delete(id);
		}else {
			throw new DeleteCustomerException("No se puede eliminar cliente con vehiculos en propiedad");
		}
		
	}
}
