package co.edu.uniquindio.ssev.vehicletracking.entry.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniquindio.ssev.vehicletracking.entry.application.CreateEntry;
import co.edu.uniquindio.ssev.vehicletracking.entry.domain.Entry;

@RestController
@RequestMapping("/entry")
public class EntryController {
	
	@Autowired
	private CreateEntry createEntry;
	
	@PostMapping
	public ResponseEntity<Entry> create(@RequestBody Entry entry){
		
		return ResponseEntity.ok(createEntry.create(entry));
	}

}
