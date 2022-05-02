package co.edu.uniquindio.ssev.vehicletracking.employee.infraestructure.controller.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uniquindio.ssev.vehicletracking.employee.infraestructure.controller.persistence.entity.EmployeeEntity;

public interface EmployeeEntityRepository extends JpaRepository<EmployeeEntity,Long> {

}
