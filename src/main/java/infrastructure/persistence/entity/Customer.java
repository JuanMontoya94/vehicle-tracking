package infrastructure.persistence.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.*;

@Getter
@Setter
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCustomer;
	
	
	private String name;
	
	private String phone;
	
	private String addres;
	
	@OneToMany
    @JoinColumn(name = "idVehicle", nullable = false)
	private Vehicle vehicle;

}
