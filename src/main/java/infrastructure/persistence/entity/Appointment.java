package infrastructure.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAppointment;
	private LocalDateTime date;
	private String state;
	
	@ManyToOne
    @JoinColumn(name = "idVehicle", nullable = false)
	private Vehicle vehicle;
	
	@ManyToOne
    @JoinColumn(name = "idEmployee", nullable = false)
    private Employee employee;
	
	@OneToOne
	@JoinColumn(name = "idEntry", nullable = false)
	private Entry entry;
	
	@ManyToMany
	private List<Service> listServices;
	


}
