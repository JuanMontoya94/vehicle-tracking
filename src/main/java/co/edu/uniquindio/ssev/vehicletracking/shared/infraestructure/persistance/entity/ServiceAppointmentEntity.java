package co.edu.uniquindio.ssev.vehicletracking.shared.infraestructure.persistance.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;

@Entity
@Getter
public class ServiceAppointmentEntity {
	
	@Id
	private Long idServiceAppointment;
	
	private String estado;
	
	@ManyToOne
	private ServiceEntity service;
	
	@OneToMany
	private List<EvidenceEntity> evidences;

}
