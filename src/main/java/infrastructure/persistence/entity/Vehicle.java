package infrastructure.persistence.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer vin;
	
	private String model;
	
	private String year;
	
	private String brand;
	
	@ManyToOne
    @JoinColumn(name = "idCustomer", nullable = false)
    private Customer customer;
	
	@OneToMany
    @JoinColumn(name = "idAppointment", nullable = false)
	private Appointment appointment;
}
