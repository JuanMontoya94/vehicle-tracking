package co.edu.uniquindio.ssev.vehicletracking.customer.infraestructure.persistence.repository;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
	public Customer save(Customer customer) {
		CustomerEntity customerEntity = modelMapper.map(customer, CustomerEntity.class);
		customerEntity = customerEntityRepository.save(customerEntity);

		return modelMapper.map(customerEntity, Customer.class);
	}

	@Override
	public void delete(Long id) {
		customerEntityRepository.deleteById(id);

	}

	@Override
	public boolean exists(Long id) {

		return customerEntityRepository.existsById(id);
	}

	@Override
	public Customer findCustomer(Long id) {

		CustomerEntity customerEntity = customerEntityRepository.findById(id).get();
		return modelMapper.map(customerEntity, Customer.class);
	}
	
	@Override
	public List<Customer> get() {
		
		List<CustomerEntity> customerEntity = customerEntityRepository.findAll();
		List<Customer> listCustomer=modelMapper.map(customerEntity,new TypeToken<List<Customer>>() {}.getType());
		
		return listCustomer;
	}

}
