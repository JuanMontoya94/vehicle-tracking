package co.edu.uniquindio.ssev.vehicletracking.appointment.domain;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ServiceAppointment {
	
	private Long id;
	
	private String estado;
	
	private Service service;
	
	private List<Evidence> evidences;

}
