package co.edu.uniquindio.ssev.vehicletracking.entry.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.ssev.vehicletracking.entry.domain.Entry;
import co.edu.uniquindio.ssev.vehicletracking.entry.domain.repository.EntryRepository;

@Service
public class GetEntry {

	@Autowired
	private EntryRepository entryRepository;
	
	public List<Entry> get(){
		return entryRepository.get();
	}
}
