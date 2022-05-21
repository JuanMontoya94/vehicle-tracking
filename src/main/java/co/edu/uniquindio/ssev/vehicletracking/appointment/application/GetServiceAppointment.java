package co.edu.uniquindio.ssev.vehicletracking.appointment.application;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.ServiceAppointment;
import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.repository.ServiceAppointmentRepository;

@Service
public class GetServiceAppointment {

  @Autowired
  private ServiceAppointmentRepository serviceAppointmentRepository;
  
  public Optional<ServiceAppointment> getServiceAppointment(Long id) {
    return serviceAppointmentRepository.getServiceAppointment(id);
  }
  
}
