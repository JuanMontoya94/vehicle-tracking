package co.edu.uniquindio.ssev.vehicletracking.entry.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.ssev.vehicletracking.entry.domain.Entry;
import co.edu.uniquindio.ssev.vehicletracking.entry.domain.repository.EntryRepository;

@Service
public class CreateEntry {
	
	@Autowired
	private EntryRepository entryRepository;
	
	public Entry create(Entry entry) {
		entry.setState("Inventario");
		return entryRepository.create(entry);
	}
	
}
