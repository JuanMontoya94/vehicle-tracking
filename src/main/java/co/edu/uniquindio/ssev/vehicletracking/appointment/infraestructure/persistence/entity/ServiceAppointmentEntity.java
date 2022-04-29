package co.edu.uniquindio.ssev.vehicletracking.appointment.infraestructure.persistence.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import co.edu.uniquindio.ssev.vehicletracking.shared.infraestructure.persistance.entity.EvidenceEntity;
import co.edu.uniquindio.ssev.vehicletracking.shared.infraestructure.persistance.entity.ServiceEntity;
import lombok.Getter;

@Entity(name="service_appointment")
@Getter
public class ServiceAppointmentEntity {
	
	@Id
	private Long id;
	
	private String estado;
	
	@ManyToOne
	private ServiceEntity service;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_service_appointment")
	private List<EvidenceEntity> evidences;

}
