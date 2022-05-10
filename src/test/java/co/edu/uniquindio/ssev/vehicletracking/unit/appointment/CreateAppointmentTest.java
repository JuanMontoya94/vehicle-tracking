package co.edu.uniquindio.ssev.vehicletracking.unit.appointment;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.edu.uniquindio.ssev.vehicletracking.appointment.application.CreateAppointment;
import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.Appointment;
import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.repository.AppointmentRepository;
import co.edu.uniquindio.ssev.vehicletracking.customer.domain.Vehicle;
import co.edu.uniquindio.ssev.vehicletracking.employee.domain.Employee;

public class CreateAppointmentTest {
	
	@InjectMocks
	private CreateAppointment createAppointment;
	
	@Mock
	private AppointmentRepository appointmentRepository;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void createWithInitData() {
		Vehicle vehicle = new Vehicle();
		vehicle.setPlate("KMP123");
		Employee employee = new Employee();
		employee.setIdEmployee((long) 10);
		Appointment appointment = new Appointment();
		appointment.setVehicle(vehicle);
		appointment.setEmployee(employee);
		
		when(appointmentRepository.save(appointment)).thenReturn(appointment);
		
		Appointment savedAppointment = createAppointment.create(appointment);
		assertThat(savedAppointment.getDate()).isNotNull();
		assertThat(savedAppointment.getStatus()).isNotNull();
		assertThat(savedAppointment.getVehicle().getPlate()).isEqualTo(vehicle.getPlate());	
		assertThat(savedAppointment.getEmployee().getIdEmployee()).isEqualTo(employee.getIdEmployee());
	}
	
	
}
