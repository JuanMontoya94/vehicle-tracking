package co.edu.uniquindio.ssev.vehicletracking.appointment.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.Appointment;
import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.repository.AppointmentRepository;

@Service
public class CreateAppointment {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	public Appointment create(Appointment appointment) {
		
		return appointmentRepository.create(appointment);
	}

}
