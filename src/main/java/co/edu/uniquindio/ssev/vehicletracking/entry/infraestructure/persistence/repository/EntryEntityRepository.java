package co.edu.uniquindio.ssev.vehicletracking.entry.infraestructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uniquindio.ssev.vehicletracking.entry.infraestructure.persistence.entity.EntryEntity;

public interface EntryEntityRepository extends JpaRepository<EntryEntity, Long>{

}
