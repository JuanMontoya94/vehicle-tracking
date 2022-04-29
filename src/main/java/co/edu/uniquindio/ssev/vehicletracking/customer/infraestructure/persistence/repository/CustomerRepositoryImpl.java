package co.edu.uniquindio.ssev.vehicletracking.customer.infraestructure.persistence.repository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.uniquindio.ssev.vehicletracking.customer.domain.Customer;
import co.edu.uniquindio.ssev.vehicletracking.customer.domain.repository.CustomerRepository;
import co.edu.uniquindio.ssev.vehicletracking.customer.infraestructure.persistence.entity.CustomerEntity;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	@Autowired
	private CustomerEntityRepository customerEntityRepository;

    @Autowired
    private ModelMapper modelMapper;
	
	@Override
	public Customer create(Customer customer) {
  	    CustomerEntity customerEntity = modelMapper.map(customer, CustomerEntity.class);
        customerEntity = customerEntityRepository.save(customerEntity);
        
        return modelMapper.map(customerEntity, Customer.class);
	}

}
