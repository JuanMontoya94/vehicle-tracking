package co.edu.uniquindio.ssev.vehicletracking.appointment.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ServiceAppointment {
	
	private Long id;
	
	private String status;
	
	private Service service;
	
	private List<Evidence> evidences = new ArrayList<>();

}
