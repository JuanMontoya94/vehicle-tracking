package co.edu.uniquindio.ssev.vehicletracking.appointment.domain.repository;

import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.Appointment;
import co.edu.uniquindio.ssev.vehicletracking.customer.domain.Customer;

public interface AppointmentRepository {

	public Appointment save(Appointment appointment);
	
	public boolean exists(Long id);
	
	public Appointment findAppointment(Long id);
}
