package co.edu.uniquindio.ssev.vehicletracking.appointment.domain.repository;

import java.util.Optional;

import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.ServiceAppointment;

public interface ServiceAppointmentRepository {

  public Optional<ServiceAppointment> getServiceAppointment(Long id);
  
  public ServiceAppointment updateServiceAppointment(ServiceAppointment serviceAppointment);
  
}
