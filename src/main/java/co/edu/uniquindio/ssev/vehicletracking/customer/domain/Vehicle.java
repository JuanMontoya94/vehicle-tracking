package co.edu.uniquindio.ssev.vehicletracking.customer.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    private String plate;
  
	private String vin;
	
	private String model;
	
	private String year;
	
	private String brand;
	
	
}
