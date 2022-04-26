package co.edu.uniquindio.ssev.vehicletracking.shared.infraestructure.persistance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Evidence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEvidence;
	
	private String urlRecourse;
	
	private String tipo;

}