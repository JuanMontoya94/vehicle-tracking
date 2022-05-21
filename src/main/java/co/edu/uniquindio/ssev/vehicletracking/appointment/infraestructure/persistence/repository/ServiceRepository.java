package co.edu.uniquindio.ssev.vehicletracking.appointment.infraestructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uniquindio.ssev.vehicletracking.appointment.infraestructure.persistence.entity.ServiceEntity;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {

}
