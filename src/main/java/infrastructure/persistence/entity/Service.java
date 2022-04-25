package infrastructure.persistence.entity;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Service {
	@Id
	private Integer idService;
	
	private int precio;

	@ManyToMany
	private List<Appointment> listAppointments;
}
