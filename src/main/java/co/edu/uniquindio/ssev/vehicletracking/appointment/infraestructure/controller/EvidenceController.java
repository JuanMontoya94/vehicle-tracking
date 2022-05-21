package co.edu.uniquindio.ssev.vehicletracking.appointment.infraestructure.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import co.edu.uniquindio.ssev.vehicletracking.appointment.application.GetServiceAppointment;
import co.edu.uniquindio.ssev.vehicletracking.appointment.application.UpdateServiceAppointment;
import co.edu.uniquindio.ssev.vehicletracking.appointment.domain.ServiceAppointment;

@RestController
@RequestMapping("/appointment")
@CrossOrigin("*")
public class EvidenceController {

  private static final String FILES_PATH = "C:\\evidences";

  @Autowired
  private GetServiceAppointment getServiceAppointment;
  @Autowired
  private UpdateServiceAppointment updateServiceAppointment;

  @PostMapping("/evidence")
  public ResponseEntity<Object> uploadEvidence(
    @RequestParam("archivo") MultipartFile evidence,
    @RequestParam("type") String type,
    @RequestParam("id") Long serviceAppointmentId
  ) {
    if(evidence.isEmpty()) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La evidencia debe ser cargada.");
    }

    Optional<ServiceAppointment> serviceAppointmentopt = getServiceAppointment.getServiceAppointment(serviceAppointmentId);
    if(serviceAppointmentopt.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body("El servicio programado con el id "+ serviceAppointmentId +" no se encuentró.");
    }
    
    ServiceAppointment serviceAppointment = serviceAppointmentopt.get();
    String fileName = UUID.randomUUID().toString() +"_"+ evidence.getOriginalFilename().replace(" ", "");
    Path filePath = Paths.get(FILES_PATH).resolve(fileName).toAbsolutePath();
    try {
      Files.copy(evidence.getInputStream(), filePath);
      ServiceAppointment savedServiceAppointment = updateServiceAppointment.updateServiceAppointment(serviceAppointment, fileName, type);
      
      return ResponseEntity.ok(savedServiceAppointment);
      
    } catch (IOException exception) {
      return ResponseEntity.internalServerError().body("Hubo un error cargando la evidencia \n"+ exception);
    }
  }
}
