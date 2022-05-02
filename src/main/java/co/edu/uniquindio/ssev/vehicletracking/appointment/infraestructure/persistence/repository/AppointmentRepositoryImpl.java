package co.edu.uniquindio.ssev.vehicletracking.appointment.infraestructure.persistence.repository;

import org.modelmapper.ModelMapper;
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
	public Appointment create(Appointment appointment) {
	
		AppointmentEntity appointmentEntity = modelMapper.map(appointment, AppointmentEntity.class);
		appointmentEntity.setVehicle(vehicleEntityRepository.findById(appointment.getVehicle().getPlate()).get());
		
		appointmentEntity.setEmployee(employeeEntityRepository.findById(appointment.getEmployee().getIdEmployee()).get());
		
		appointmentEntity = appointmentEntityRepository.save(appointmentEntity);
		
		return modelMapper.map(appointmentEntity, Appointment.class);
	}
}
