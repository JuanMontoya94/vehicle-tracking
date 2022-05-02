package co.edu.uniquindio.ssev.vehicletracking.employee.infraestructure.controller.persistence.repository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.uniquindio.ssev.vehicletracking.employee.domain.Employee;
import co.edu.uniquindio.ssev.vehicletracking.employee.domain.repository.EmployeeRepository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
	private EmployeeEntityRepository employeeEntityRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Employee create(Employee employee) {
		
		return null;
	}

}
