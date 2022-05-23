package co.edu.uniquindio.ssev.vehicletracking.entry.infraestructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniquindio.ssev.vehicletracking.entry.application.CreateEntry;
import co.edu.uniquindio.ssev.vehicletracking.entry.application.GetEntry;
import co.edu.uniquindio.ssev.vehicletracking.entry.domain.Entry;

@RestController
@RequestMapping("/entry")
@CrossOrigin("*")
public class EntryController {
	
	@Autowired
	private CreateEntry createEntry;
	
	@Autowired
	private GetEntry getEntry;
	
	@PostMapping
	public ResponseEntity<Object> create(@RequestBody Entry entry){
		try {
			return ResponseEntity.ok(createEntry.create(entry));
			
		} catch (Exception exception) {
			return ResponseEntity.internalServerError().body(exception.getCause().getMessage());
		}
	}
	
	@GetMapping
	public List<Entry> get(){
		return getEntry.get();
	}

}
