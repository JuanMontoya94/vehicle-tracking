package co.edu.uniquindio.ssev.vehicletracking.appointment.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.Appointment;
import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.repository.AppointmentRepository;

@Service
public class GetAppointment {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	public List<Appointment> get(){
		return appointmentRepository.get();
	}
}
