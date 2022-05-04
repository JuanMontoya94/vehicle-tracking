package co.edu.uniquindio.ssev.vehicletracking.entry.domain;

import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.Appointment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Entry  {
	
	private Long id;
	
	private String state;
	
	private int km;
	
	private Appointment appointment;
	
}
