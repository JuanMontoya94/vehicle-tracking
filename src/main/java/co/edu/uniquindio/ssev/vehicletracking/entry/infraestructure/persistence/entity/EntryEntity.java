package co.edu.uniquindio.ssev.vehicletracking.entry.infraestructure.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import co.edu.uniquindio.ssev.vehicletracking.appointment.infraestructure.persistence.entity.AppointmentEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name="entry")
@Getter
@Setter
@ToString
public class EntryEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String state;
	
	private int km;
	
	@OneToOne
	@JoinColumn(name = "id_appointment", referencedColumnName = "id", unique = true)
	private AppointmentEntity appointment;
}
