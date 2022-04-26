package co.edu.uniquindio.ssev.vehicletracking.customer.infraestructure.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import co.edu.uniquindio.ssev.vehicletracking.customer.domain.Vehicle;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class VehicleEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vin;
	
	private String model;
	
	private String year;
	
	private String brand;
	
	public VehicleEntity(Vehicle vehicle) {
		this.vin = vehicle.getVin();
		this.model=vehicle.getModel();
		this.year=vehicle.getYear();
		this.brand=vehicle.getBrand();
	}
	
	public static Vehicle load(VehicleEntity vehicleEntity) {
		return new Vehicle(vehicleEntity.getVin(), vehicleEntity.getModel(), vehicleEntity.getYear(), vehicleEntity.getBrand());
	}
	
	
}
