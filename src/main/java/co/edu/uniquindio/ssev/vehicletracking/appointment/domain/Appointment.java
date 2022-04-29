package co.edu.uniquindio.ssev.vehicletracking.appointment.domain;

import java.time.LocalDateTime;
import java.util.List;

import co.edu.uniquindio.ssev.vehicletracking.customer.domain.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
	
	private Long id;
	
	private LocalDateTime date;
	
	private String state;
	
	private Vehicle vehicle;
	
    private Employee employee;
	
	private List<ServiceAppointment> serviceAppointments;

}
