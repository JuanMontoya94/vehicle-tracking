package co.edu.uniquindio.ssev.vehicletracking.customer.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.ssev.vehicletracking.customer.domain.Vehicle;
import co.edu.uniquindio.ssev.vehicletracking.customer.domain.repository.VehicleRepository;

@Service
public class CreateVehicle {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	public Vehicle create(Vehicle vehicle) {
		return vehicleRepository.create(vehicle);
	}

}
