package co.edu.uniquindio.ssev.vehicletracking.appointment.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.Appointment;
import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.exception.AppointmentNotFoundException;
import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.repository.AppointmentRepository;

@Service
public class UpdateAppointment {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	public Appointment update(Appointment appointment) {
		
		if(appointmentRepository.exists(appointment.getId())) {
			Appointment savedAppointment = appointmentRepository.findAppointment(appointment.getId());
			savedAppointment.updateData(appointment);
			
			return appointmentRepository.save(savedAppointment);
		}
		
		throw new AppointmentNotFoundException("La cita con id "+ appointment.getId() +" no existe!");
	}
}