package co.edu.uniquindio.ssev.vehicletracking.appointment.infraestructure.persistence.repository;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.Appointment;
import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.repository.AppointmentRepository;
import co.edu.uniquindio.ssev.vehicletracking.appointment.infraestructure.persistence.entity.AppointmentEntity;
import co.edu.uniquindio.ssev.vehicletracking.customer.infraestructure.persistence.repository.VehicleEntityRepository;
import co.edu.uniquindio.ssev.vehicletracking.employee.infraestructure.controller.persistence.repository.EmployeeEntityRepository;

@Repository
public class AppointmentRepositoryImpl implements AppointmentRepository {

	@Autowired
	private AppointmentEntityRepository appointmentEntityRepository;
	
	@Autowired
	private VehicleEntityRepository vehicleEntityRepository;
	
	@Autowired
	private EmployeeEntityRepository employeeEntityRepository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public Appointment save(Appointment appointment) {
	
		AppointmentEntity appointmentEntity = modelMapper.map(appointment, AppointmentEntity.class);
		appointmentEntity.setVehicle(vehicleEntityRepository.findById(appointment.getVehicle().getPlate()).get());
		
		appointmentEntity.setEmployee(employeeEntityRepository.findById(appointment.getEmployee().getIdEmployee()).get());
		
		appointmentEntity = appointmentEntityRepository.save(appointmentEntity);
		
		return modelMapper.map(appointmentEntity, Appointment.class);
	}
	
	@Override
	public boolean exists(Long id) {
		
		return appointmentEntityRepository.existsById(id);
	}

	@Override
	public Appointment findAppointment(Long id) {
		AppointmentEntity appointmentEntity = appointmentEntityRepository.findById(id).get();
		
		return modelMapper.map(appointmentEntity,Appointment.class);
	}

	@Override
	public List<Appointment> get() {
		
		List<AppointmentEntity> appointmentEntity = appointmentEntityRepository.findAll();
		List<Appointment> listAppointments = modelMapper.map(appointmentEntity,new TypeToken<List<Appointment>>() {}.getType());
		
		return listAppointments;
	}

	@Override
	public void delete(Long id) {
		appointmentEntityRepository.deleteById(id);
	}
		
}
