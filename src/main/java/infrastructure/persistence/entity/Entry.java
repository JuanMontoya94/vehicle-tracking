package infrastructure.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Entry 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEntry;
	private String state;
	
	@OneToOne
	@JoinColumn(name = "idAppointment", nullable = false)
	private Appointment appointment;
}
