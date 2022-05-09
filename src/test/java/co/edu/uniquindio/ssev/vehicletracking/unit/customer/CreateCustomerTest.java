package co.edu.uniquindio.ssev.vehicletracking.unit.customer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.edu.uniquindio.ssev.vehicletracking.customer.application.CreateCustomer;
import co.edu.uniquindio.ssev.vehicletracking.customer.domain.Customer;
import co.edu.uniquindio.ssev.vehicletracking.customer.domain.repository.CustomerRepository;

public class CreateCustomerTest {

	@InjectMocks
	private CreateCustomer createCustomer;
	
	@Mock
	private CustomerRepository customerRepository;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);

	}
	
	@Test
	public void createWithInitData() {
		Customer customer = new Customer();
		customer.setEmail("correo@correo.com");
		
		when(customerRepository.save(customer)).thenReturn(customer);
		
		Customer savedCustomer = createCustomer.create(customer);
		assertThat(savedCustomer.getEmail()).isNotNull();

	}
}
