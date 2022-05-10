package co.edu.uniquindio.ssev.vehicletracking.unit.appointment;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
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
	
	@Captor
	private ArgumentCaptor<Appointment> appointmentCaptor;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void updateStatusThrowAppointmentNotFoundException() {
		Appointment appointment = new Appointment();
		
		when(appointmentRepository.exists(appointment.getId())).thenReturn(false);
		
		assertThrows(AppointmentNotFoundException.class, () -> 
			updateAppointment.update(appointment)
		);
	}
	
	@Test
	public void updateAppointmentStatus() {
		Appointment appointment = new Appointment();
		appointment.setId(1L);
		appointment.setStatus("Inventario");
		Appointment savedAppointment = new Appointment();
		savedAppointment.setId(1L);

		
		when(appointmentRepository.exists(appointment.getId())).thenReturn(true);
		when(appointmentRepository.findAppointment(appointment.getId()))
			.thenReturn(savedAppointment);
		
		updateAppointment.update(appointment);
		verify(appointmentRepository).save(appointmentCaptor.capture());
		
		assertThat(appointment.getId()).isEqualTo(appointmentCaptor.getValue().getId());
		assertThat(appointment.getStatus()).isEqualTo(appointmentCaptor.getValue().getStatus());
		
	}

}
