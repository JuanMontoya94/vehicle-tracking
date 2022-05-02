package co.edu.uniquindio.ssev.vehicletracking.customer.infraestructure.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="vehicle")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleEntity {
	
	@Id
	private String plate;
	
	@Column(unique = true)
	private String vin;
	
	private String model;
	
	private String year;
	
	private String brand;
	
	@ManyToOne
	@JoinColumn(name = "id_customer", nullable = false)
	private CustomerEntity customer;
	
}
