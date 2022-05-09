package co.edu.uniquindio.ssev.vehicletracking.unit.appointment;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.edu.uniquindio.ssev.vehicletracking.appointment.application.UpdateAppointment;
import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.Appointment;
import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.exception.AppointmentNotFoundException;
import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.repository.AppointmentRepository;

public class UpdateAppointmentTest {
	
	@InjectMocks
	private UpdateAppointment updateAppointment;
	
	@Mock
	private AppointmentRepository appointmentRepository;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void updateWithInitData() {
		Appointment appointment = new Appointment();
		
//		when(appointmentRepository.exists(appointment.getId())).thenReturn(true);
//		
//		updateAppointment.update(appointment);
		
		when(appointmentRepository.exists(appointment.getId())).thenReturn(false).thenThrow(new AppointmentNotFoundException("mensaje"));
		
	}

}
