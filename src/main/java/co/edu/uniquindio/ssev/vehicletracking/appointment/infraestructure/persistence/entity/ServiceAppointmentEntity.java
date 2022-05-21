package co.edu.uniquindio.ssev.vehicletracking.appointment.infraestructure.persistence.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import co.edu.uniquindio.ssev.vehicletracking.shared.infraestructure.persistance.entity.EvidenceEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="service_appointment")
@Getter
@Setter
@NoArgsConstructor
public class ServiceAppointmentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String status;
	
	@ManyToOne
	private ServiceEntity service;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_service_appointment")
	private List<EvidenceEntity> evidences = new ArrayList<>();
}
