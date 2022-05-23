package co.edu.uniquindio.ssev.vehicletracking.entry.domain.repository;

import java.util.List;

import co.edu.uniquindio.ssev.vehicletracking.entry.domain.Entry;

public interface EntryRepository {

	public Entry create(Entry entry);
	
	public List<Entry> get();
}
