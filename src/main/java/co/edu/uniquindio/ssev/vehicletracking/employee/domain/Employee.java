package co.edu.uniquindio.ssev.vehicletracking.employee.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	private Long id;
	
	private String name;
	
	private String phone;
	
	private String addres;
	
	private Rol rol;

}
