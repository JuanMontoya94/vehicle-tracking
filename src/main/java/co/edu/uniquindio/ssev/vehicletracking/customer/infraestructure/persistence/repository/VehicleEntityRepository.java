package co.edu.uniquindio.ssev.vehicletracking.customer.infraestructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uniquindio.ssev.vehicletracking.customer.infraestructure.persistence.entity.VehicleEntity;

public interface VehicleEntityRepository extends JpaRepository<VehicleEntity, String> {
	 
}
