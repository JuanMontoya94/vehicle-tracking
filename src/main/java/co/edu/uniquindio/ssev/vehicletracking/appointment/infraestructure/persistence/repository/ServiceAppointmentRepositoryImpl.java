package co.edu.uniquindio.ssev.vehicletracking.appointment.infraestructure.persistence.repository;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.ServiceAppointment;
import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.repository.ServiceAppointmentRepository;
import co.edu.uniquindio.ssev.vehicletracking.appointment.infraestructure.persistence.entity.ServiceAppointmentEntity;

@Repository
public class ServiceAppointmentRepositoryImpl implements ServiceAppointmentRepository {

  @Autowired
  private ServiceAppointmentEntityRepository serviceAppointmentEntityRepository;
  
  @Autowired
  private ModelMapper modelMapper;

  @Override
  public Optional<ServiceAppointment> getServiceAppointment(Long id) {
    Optional<ServiceAppointmentEntity> serviceAppointmentEntityOpt = serviceAppointmentEntityRepository.findById(id);
    
    if(serviceAppointmentEntityOpt.isPresent()) {
      ServiceAppointment serviceAppointment = modelMapper.map(serviceAppointmentEntityOpt.get(), ServiceAppointment.class);
      return Optional.of(serviceAppointment);
    }
    
    return Optional.empty();
  }

  @Override
  public ServiceAppointment updateServiceAppointment(ServiceAppointment serviceAppointment) {
    ServiceAppointmentEntity serviceAppointmentEntity = modelMapper.map(serviceAppointment, ServiceAppointmentEntity.class);
    serviceAppointmentEntity = serviceAppointmentEntityRepository.save(serviceAppointmentEntity);
    
    return modelMapper.map(serviceAppointmentEntity, ServiceAppointment.class);
  }
  
}
