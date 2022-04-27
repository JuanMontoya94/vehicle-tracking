package co.edu.uniquindio.ssev.vehicletracking.customer.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniquindio.ssev.vehicletracking.customer.application.CreateVehicle;
import co.edu.uniquindio.ssev.vehicletracking.customer.domain.Vehicle;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	
	 @Autowired
	 private CreateVehicle createVehicle;
	 
	 public ResponseEntity<Vehicle> create (@RequestBody Vehicle vehicle){
		 
		 Vehicle newVehicle=createVehicle.create(vehicle);
		 return ResponseEntity.ok(newVehicle);
	 }
}
