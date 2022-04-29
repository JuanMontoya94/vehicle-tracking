package co.edu.uniquindio.ssev.vehicletracking.customer.infraestructure.persistence.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.uniquindio.ssev.vehicletracking.customer.domain.Customer;
import co.edu.uniquindio.ssev.vehicletracking.customer.domain.Vehicle;
import co.edu.uniquindio.ssev.vehicletracking.customer.domain.repository.CustomerRepository;
import co.edu.uniquindio.ssev.vehicletracking.customer.infraestructure.persistence.entity.CustomerEntity;
import co.edu.uniquindio.ssev.vehicletracking.customer.infraestructure.persistence.entity.VehicleEntity;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	@Autowired
	private CustomerEntityRepository customerEntityRepository;
	
	@Override
	public Customer create(Customer customer) {
		
		List<VehicleEntity> vehicleEntities = customer.getVehicles().stream()
				.map(VehicleEntity::new)
				.collect(Collectors.toList());
		
		CustomerEntity customerEntity = new CustomerEntity(customer.getId(),customer.getName(),customer.getPhone(),customer.getCorreo(), vehicleEntities);
		customerEntity = customerEntityRepository.save(customerEntity);  
		
		List<Vehicle> vehicles = customerEntity.getVehicles().stream()
				.map(VehicleEntity::load)
				.collect(Collectors.toList());
	
		return new Customer(customerEntity.getId(),customerEntity.getName(),customerEntity.getPhone(),customer.getCorreo(), vehicles);
	}
	
	

}
