package co.edu.uniquindio.ssev.vehicletracking.shared.infraestructure.persistance.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;

@Entity
@Getter
public class ServiceAppointment {
	
	@Id
	private Long idServiceAppointment;
	
	private String estado;
	
	@ManyToOne
	private Service service;
	
	@OneToMany
	private List<Evidence> evidences;

}
