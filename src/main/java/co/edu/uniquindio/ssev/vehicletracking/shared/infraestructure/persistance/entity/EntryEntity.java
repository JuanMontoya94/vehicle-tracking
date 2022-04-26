package co.edu.uniquindio.ssev.vehicletracking.shared.infraestructure.persistance.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Entry 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEntry;
	private String state;
	private int km;
	
	@OneToOne
	@JoinColumn(name = "idAppointment", nullable = false)
	private AppointmentEntity appointment;
}
