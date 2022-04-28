package co.edu.uniquindio.ssev.vehicletracking.shared.infraestructure.persistance.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import co.edu.uniquindio.ssev.vehicletracking.customer.infraestructure.persistence.entity.VehicleEntity;
import lombok.Getter;
import lombok.Setter;

@Entity(name="appointment")
@Getter
@Setter
public class AppointmentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime date;
	private String state;
	
	@ManyToOne
    @JoinColumn(name = "idVehicle", nullable = false)
	private VehicleEntity vehicle;
	
	@ManyToOne
    @JoinColumn(name = "idEmployee", nullable = false)
    private EmployeeEntity employee;
	
	@OneToOne
	@JoinColumn(name = "idEntry", nullable = false)
	private EntryEntity entry;
	
	@OneToMany
	@JoinColumn(name = "id_appointment")
	private List<ServiceAppointmentEntity> serviceAppointments;
	


}
