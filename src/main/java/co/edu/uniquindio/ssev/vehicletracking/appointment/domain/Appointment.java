package co.edu.uniquindio.ssev.vehicletracking.appointment.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniquindio.ssev.vehicletracking.customer.domain.Customer;
import co.edu.uniquindio.ssev.vehicletracking.customer.domain.Vehicle;
import co.edu.uniquindio.ssev.vehicletracking.employee.domain.Employee;
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
	
	private List<ServiceAppointment> serviceAppointments =  new ArrayList<>();
	
	public void updateData(Appointment appointment) {
		if(appointment.getDate()!=null) {
			this.setDate(appointment.getDate());
		}
		if(appointment.getState()!=null) {
			this.setState(appointment.getState());
		}
		if(appointment.getVehicle()!=null) {
			this.setVehicle(appointment.getVehicle());
		}
		if(appointment.getEmployee()!=null) {
			this.setEmployee(appointment.getEmployee());
		}
		if(!appointment.getServiceAppointments().isEmpty()) {
			this.getServiceAppointments().addAll(appointment.getServiceAppointments());
		}
		
		
	}

}
