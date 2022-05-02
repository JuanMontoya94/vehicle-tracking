package co.edu.uniquindio.ssev.vehicletracking.appointment.domain.repository;

import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.Appointment;

public interface AppointmentRepository {

	public Appointment save(Appointment appointment);
	
	public boolean exists(Long id);
}
