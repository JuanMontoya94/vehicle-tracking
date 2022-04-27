package co.edu.uniquindio.ssev.vehicletracking.shared.infraestructure.persistance.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity(name="service")
@Getter
@Setter
public class ServiceEntity {
	
	@Id
	private Long idService;
	
	private String description;

}
