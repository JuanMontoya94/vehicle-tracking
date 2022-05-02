package co.edu.uniquindio.ssev.vehicletracking.entry.infraestructure.persistence.repository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.uniquindio.ssev.vehicletracking.appointment.infraestructure.persistence.entity.AppointmentEntity;
import co.edu.uniquindio.ssev.vehicletracking.appointment.infraestructure.persistence.repository.AppointmentEntityRepository;
import co.edu.uniquindio.ssev.vehicletracking.entry.domain.Entry;
import co.edu.uniquindio.ssev.vehicletracking.entry.domain.repository.EntryRepository;
import co.edu.uniquindio.ssev.vehicletracking.entry.infraestructure.persistence.entity.EntryEntity;
import lombok.ToString;

@Repository
public class EntryRepositoryImpl implements EntryRepository {

	@Autowired
	private EntryEntityRepository entryEntityRepository;
	
	@Autowired
	private AppointmentEntityRepository appointmentEntityRepository;
	
	
	private AppointmentEntity appointmentEntity;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Entry create(Entry entry) {
		
		EntryEntity entryEntity = modelMapper.map(entry,EntryEntity.class);
		System.out.println(appointmentEntityRepository.findById(entry.getId()).get());
		//entryEntity.setAppointment(appointmentEntityRepository.findById(entry.getId()).get());
		entryEntity = entryEntityRepository.save(entryEntity);
		return modelMapper.map(entryEntity,Entry.class);
	}
}
