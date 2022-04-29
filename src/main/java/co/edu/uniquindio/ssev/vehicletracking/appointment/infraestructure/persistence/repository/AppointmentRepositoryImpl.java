package co.edu.uniquindio.ssev.vehicletracking.appointment.infraestructure.persistence.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.Appointment;
import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.repository.AppointmentRepository;

@Repository
public class AppointmentRepositoryImpl implements AppointmentRepository {

	@Autowired
	private AppointmentEntityRepository appointmentEntityRepository;

	@Override
	public Appointment create(Appointment appointment) {
		// TODO Auto-generated method stub
		return null;
	}
}
