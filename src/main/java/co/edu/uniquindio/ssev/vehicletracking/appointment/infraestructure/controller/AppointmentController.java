package co.edu.uniquindio.ssev.vehicletracking.appointment.infraestructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniquindio.ssev.vehicletracking.appointment.application.CreateAppointment;
import co.edu.uniquindio.ssev.vehicletracking.appointment.application.DeleteAppointment;
import co.edu.uniquindio.ssev.vehicletracking.appointment.application.GetAppointment;
import co.edu.uniquindio.ssev.vehicletracking.appointment.application.UpdateAppointment;
import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.Appointment;
import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.exception.AppointmentNotFoundException;

@RestController
@RequestMapping("/appointment")
@CrossOrigin("*")
public class AppointmentController {
	
	@Autowired
	private CreateAppointment createAppointment;
	
	@Autowired
	private UpdateAppointment updateAppointment;
	
	@Autowired
	private GetAppointment getAppointment;
	
	@Autowired
	private DeleteAppointment deleteAppointment;
	
	@GetMapping
	public List<Appointment> get(){
		return getAppointment.get();
	}
	
	@PostMapping
	public ResponseEntity<Appointment> create(@RequestBody Appointment appointment) {
		return ResponseEntity.ok(createAppointment.create(appointment));
	}
	
	@PatchMapping
	public ResponseEntity<Object> update(@RequestBody Appointment appointment){
		try {
			return ResponseEntity.ok(updateAppointment.update(appointment));
		} catch (AppointmentNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());

		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		deleteAppointment.delete(id);
		return ResponseEntity.ok("la cita ha sido eliminada");

	}
	
}
