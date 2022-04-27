package co.edu.uniquindio.ssev.vehicletracking.shared.infraestructure.persistance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
@Entity(name="employee")
@Getter
@Setter
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmployee;
	
	private String name;
	
	private String phone;
	
	private String addres;
	
	private String rol;

}
