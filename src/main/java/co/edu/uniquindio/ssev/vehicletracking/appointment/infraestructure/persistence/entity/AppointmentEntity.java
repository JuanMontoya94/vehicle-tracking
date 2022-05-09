package co.edu.uniquindio.ssev.vehicletracking.appointment.infraestructure.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import co.edu.uniquindio.ssev.vehicletracking.customer.infraestructure.persistence.entity.VehicleEntity;
import co.edu.uniquindio.ssev.vehicletracking.employee.infraestructure.controller.persistence.entity.EmployeeEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name="appointment")
@ToString
@Getter
@Setter
public class AppointmentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private LocalDateTime date;
	
	@Column(nullable = false)
	private String state;
	
	@ManyToOne
    @JoinColumn(name = "idVehicle", nullable = false)
	private VehicleEntity vehicle;
	
	@ManyToOne
    @JoinColumn(name = "idEmployee", nullable = false)
    private EmployeeEntity employee;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_appointment")
	private List<ServiceAppointmentEntity> serviceAppointments;

}
