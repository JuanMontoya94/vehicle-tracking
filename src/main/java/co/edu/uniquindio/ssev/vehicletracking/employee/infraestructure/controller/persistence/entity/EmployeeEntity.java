package co.edu.uniquindio.ssev.vehicletracking.employee.infraestructure.controller.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import co.edu.uniquindio.ssev.vehicletracking.employee.domain.Rol;
import lombok.Getter;
import lombok.Setter;
@Entity(name="employee")
@Getter
@Setter
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String phone;
	
	private String addres;
	
	private Rol rol;

}
