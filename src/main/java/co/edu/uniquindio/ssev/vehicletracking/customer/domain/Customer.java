package co.edu.uniquindio.ssev.vehicletracking.customer.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	private Long id;
	
	private String email;
	
	private String name;
	
	private String phone;
	
	private List<Vehicle> vehicles = new ArrayList<>();

	public void updateData(Customer customer) {
		if(customer.getEmail()!=null) {
			this.setEmail(customer.getEmail());
		}
		if(customer.getName()!=null) {
			this.setName(customer.getName());
		}
		if(customer.getPhone()!=null) {
			this.setPhone(customer.getPhone());
		}
		if(!customer.getVehicles().isEmpty()) {
			this.getVehicles().addAll(customer.getVehicles());
		}
	}
}
