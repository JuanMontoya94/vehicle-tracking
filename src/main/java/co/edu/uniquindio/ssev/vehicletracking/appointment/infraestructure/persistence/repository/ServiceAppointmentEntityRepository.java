package co.edu.uniquindio.ssev.vehicletracking.appointment.infraestructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uniquindio.ssev.vehicletracking.appointment.infraestructure.persistence.entity.ServiceAppointmentEntity;

public interface ServiceAppointmentEntityRepository extends JpaRepository<ServiceAppointmentEntity, Long> {

}
