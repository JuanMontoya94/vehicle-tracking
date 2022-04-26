package co.edu.uniquindio.ssev.vehicletracking.shared.infraestructure.persistance.entity;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import co.edu.uniquindio.ssev.vehicletracking.customer.infraestructure.persistence.entity.VehicleEntity;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class AppointmentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAppointment;
	private LocalDateTime date;
	private String state;
	
	@ManyToOne
    @JoinColumn(name = "idVehicle", nullable = false)
	private VehicleEntity vehicle;
	
	@ManyToOne
    @JoinColumn(name = "idEmployee", nullable = false)
    private Employee employee;
	
	@OneToOne
	@JoinColumn(name = "idEntry", nullable = false)
	private Entry entry;
	
	@OneToMany
	private List<ServiceAppointment> serviceAppointments;
	


}
