package co.edu.uniquindio.ssev.vehicletracking.customer.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.ssev.vehicletracking.customer.domain.exception.CustomerCantBeDeletedException;
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
		CustomerEntity customer = customerEntityRepository.findById(id).get();
		
		if (customer.getVehicles().isEmpty()) {
			customerRepository.delete(id);
		} else {
			throw new CustomerCantBeDeletedException("No se puede eliminar cliente con vehiculos en propiedad");
		}

	}
}
