package co.edu.uniquindio.ssev.vehicletracking.appointment.domain.repository;

import java.util.List;

import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.Appointment;

public interface AppointmentRepository {

	public Appointment save(Appointment appointment);
	
	public boolean exists(Long id);
	
	public Appointment findAppointment(Long id);
	
	public List<Appointment> get();
	
	public void delete(Long id);

}
