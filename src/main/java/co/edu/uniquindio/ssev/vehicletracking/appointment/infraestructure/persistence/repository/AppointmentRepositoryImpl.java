package co.edu.uniquindio.ssev.vehicletracking.appointment.infraestructure.persistence.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.Appointment;
import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.repository.AppointmentRepository;
import co.edu.uniquindio.ssev.vehicletracking.appointment.infraestructure.persistence.entity.AppointmentEntity;
import co.edu.uniquindio.ssev.vehicletracking.appointment.infraestructure.persistence.entity.ServiceAppointmentEntity;
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
	private ServiceRepository serviceRepository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public Appointment save(Appointment appointment) {
	
		AppointmentEntity appointmentEntity = modelMapper.map(appointment, AppointmentEntity.class);
		List<ServiceAppointmentEntity> serviceAppointments = appointment.getServiceAppointments().stream()
		    .map(serviceAppointment -> {
		      ServiceAppointmentEntity serviceAppointmentEntity = new ServiceAppointmentEntity();
		      serviceAppointmentEntity.setStatus("Abierto");
		      serviceAppointmentEntity.setService(serviceRepository.findById(serviceAppointment.getService().getId()).get());
		      
		      return serviceAppointmentEntity;
		    })
		    .collect(Collectors.toList());		
		
		appointmentEntity.setVehicle(vehicleEntityRepository.findById(appointment.getVehicle().getPlate()).get());
		appointmentEntity.setEmployee(employeeEntityRepository.findById(appointment.getEmployee().getId()).get());
		appointmentEntity.setServiceAppointments(serviceAppointments);
		
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
