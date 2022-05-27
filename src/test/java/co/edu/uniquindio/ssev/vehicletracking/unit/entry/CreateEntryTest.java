package co.edu.uniquindio.ssev.vehicletracking.unit.entry;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.edu.uniquindio.ssev.vehicletracking.entry.application.CreateEntry;
import co.edu.uniquindio.ssev.vehicletracking.entry.domain.Entry;
import co.edu.uniquindio.ssev.vehicletracking.entry.domain.repository.EntryRepository;

public class CreateEntryTest {

	@InjectMocks
	private CreateEntry createEntry;
	
	@Mock
	private EntryRepository entryRepository;
	
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);

	}
	
	@Test
	public void createWithInitData() {
		Entry entry = new Entry();
		
		when(entryRepository.create(entry)).thenReturn(entry);
		
		createEntry.create(entry);

	}
}
