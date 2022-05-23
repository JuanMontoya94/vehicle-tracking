package co.edu.uniquindio.ssev.vehicletracking.entry.infraestructure.persistence.repository;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.uniquindio.ssev.vehicletracking.appointment.infraestructure.persistence.entity.AppointmentEntity;
import co.edu.uniquindio.ssev.vehicletracking.appointment.infraestructure.persistence.repository.AppointmentEntityRepository;
import co.edu.uniquindio.ssev.vehicletracking.entry.domain.Entry;
import co.edu.uniquindio.ssev.vehicletracking.entry.domain.repository.EntryRepository;
import co.edu.uniquindio.ssev.vehicletracking.entry.infraestructure.persistence.entity.EntryEntity;

@Repository
public class EntryRepositoryImpl implements EntryRepository {

	@Autowired
	private EntryEntityRepository entryEntityRepository;
	
	@Autowired
	private AppointmentEntityRepository appointmentEntityRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Entry create(Entry entry) {
		EntryEntity entryEntity = modelMapper.map(entry, EntryEntity.class);
		AppointmentEntity appointmentEntity = appointmentEntityRepository.findById(entry.getAppointment().getId()).get();
		entryEntity.setAppointment(appointmentEntity);
		entryEntity = entryEntityRepository.save(entryEntity);

		return modelMapper.map(entryEntity,Entry.class);
	}

	@Override
	public List<Entry> get() {
		
		List<EntryEntity> entryEntity = entryEntityRepository.findAll();
		List<Entry> listEntries = modelMapper.map(entryEntity, new TypeToken<List<Entry>>() {}.getType());
		return listEntries;
	}
}
