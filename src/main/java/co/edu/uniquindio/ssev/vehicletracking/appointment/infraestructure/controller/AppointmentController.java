package co.edu.uniquindio.ssev.vehicletracking.appointment.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniquindio.ssev.vehicletracking.appointment.application.CreateAppointment;
import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.Appointment;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	
	@Autowired
	private CreateAppointment createAppointment;
	
	@PostMapping
	public ResponseEntity<Appointment> create(@RequestBody Appointment appointment) {
		return ResponseEntity.ok(createAppointment.create(appointment));
	}
}
