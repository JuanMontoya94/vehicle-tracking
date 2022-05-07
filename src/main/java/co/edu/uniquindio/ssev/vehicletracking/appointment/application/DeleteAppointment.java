package co.edu.uniquindio.ssev.vehicletracking.appointment.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.repository.AppointmentRepository;

@Service
public class DeleteAppointment {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	public void delete(Long id) {
		appointmentRepository.delete(id);
	}
}
