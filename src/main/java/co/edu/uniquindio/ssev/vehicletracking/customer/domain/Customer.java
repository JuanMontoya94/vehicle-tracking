package co.edu.uniquindio.ssev.vehicletracking.customer.domain;

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
	
	private String correo;
	
	private String name;
	
	private String phone;
	
	private List<Vehicle> vehicles;

}
