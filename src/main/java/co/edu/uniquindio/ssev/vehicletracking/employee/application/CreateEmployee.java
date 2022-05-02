package co.edu.uniquindio.ssev.vehicletracking.employee.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.ssev.vehicletracking.employee.domain.Employee;
import co.edu.uniquindio.ssev.vehicletracking.employee.domain.repository.EmployeeRepository;

@Service
public class CreateEmployee {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee create(Employee employee) {
		return employeeRepository.create(employee);
	}

}
