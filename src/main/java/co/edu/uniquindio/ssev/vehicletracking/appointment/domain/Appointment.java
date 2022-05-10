package co.edu.uniquindio.ssev.vehicletracking.appointment.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniquindio.ssev.vehicletracking.customer.domain.Vehicle;
import co.edu.uniquindio.ssev.vehicletracking.employee.domain.Employee;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Appointment {
	
	private Long id;
	
	private LocalDateTime date;
	
	private String status;
	
	private Vehicle vehicle;
	
    private Employee employee;
	
	private List<ServiceAppointment> serviceAppointments =  new ArrayList<>();
	
	public void updateData(Appointment appointment) {
		if(appointment.getDate() != null) {
			this.setDate(appointment.getDate());
		}
		if(appointment.getStatus() != null) {
			this.setStatus(appointment.getStatus());
		}
		if(appointment.getVehicle() != null) {
			this.setVehicle(appointment.getVehicle());
		}
		if(appointment.getEmployee() != null) {
			this.setEmployee(appointment.getEmployee());
		}
		if(!appointment.getServiceAppointments().isEmpty()) {
			this.getServiceAppointments().addAll(appointment.getServiceAppointments());
		}
	}

}
