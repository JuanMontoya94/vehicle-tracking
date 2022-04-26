package co.edu.uniquindio.ssev.vehicletracking.shared.infraestructure.persistance.entity;

import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Service {
	@Id
	private Long idService;
	
	private String description;

	
}
