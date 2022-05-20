package co.edu.uniquindio.ssev.vehicletracking.service.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity(name="service")

public class ServiceEntity {
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;

}
