package co.edu.uniquindio.ssev.vehicletracking.appointment.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Evidence {

	private Long id;
	
	private String name;
	
	private String type;

	public Evidence(String name, String type) {
	  this.name = name;
	  this.type = type;
	}
}
