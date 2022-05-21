package co.edu.uniquindio.ssev.vehicletracking.appointment.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.Evidence;
import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.ServiceAppointment;
import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.repository.ServiceAppointmentRepository;

@Service
public class UpdateServiceAppointment {

  @Autowired
  private ServiceAppointmentRepository serviceAppointmentRepository;
  
  public ServiceAppointment updateServiceAppointment(
    ServiceAppointment serviceAppointment,
    String evidenceName,
    String evidenceType
  ) {
    
    Evidence evidence = new Evidence(evidenceName, evidenceType);
    serviceAppointment.getEvidences().add(evidence);
    
    return serviceAppointmentRepository.updateServiceAppointment(serviceAppointment);
  }
  
}
