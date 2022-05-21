package co.edu.uniquindio.ssev.vehicletracking.appointment.infraestructure.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="service")
@Getter
@Setter
@NoArgsConstructor
public class ServiceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;

	public ServiceEntity(String description) {
	  this.description = description;
	}
}
