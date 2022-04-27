package co.edu.uniquindio.ssev.vehicletracking.shared.infraestructure.persistance.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;

@Entity(name="service_appointment")
@Getter
public class ServiceAppointmentEntity {
	
	@Id
	private Long idServiceAppointment;
	
	private String estado;
	
	@ManyToOne
	private ServiceEntity service;
	
	@OneToMany
	@JoinColumn(name = "id_service_appointment")
	private List<EvidenceEntity> evidences;

}
