package co.edu.uniquindio.ssev.vehicletracking.service.application;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.ssev.vehicletracking.service.domain.Service;
import co.edu.uniquindio.ssev.vehicletracking.service.domain.repository.ServiceRepository;

@Service
public class CreateService {
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	public Service create(Service service) {
		service.setDate(LocalDateTime.now());
		service.setState("Pendiente");
		return serviceRepository.save(service);
	}

}
