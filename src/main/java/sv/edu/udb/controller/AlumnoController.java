package sv.edu.udb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.model.dto.AlumnoDTO;
import sv.edu.udb.service.AlumnoService;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {
    // Inyeccion de dependencias
    private final AlumnoService alumnoService;

    // Constructor para inyectar el servicio
    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    // Métodos para manejar las solicitudes HTTP

    // Obtener todos los alumnos
    @GetMapping
    public ResponseEntity<List<AlumnoDTO>> getAllAlumnos() {
        return ResponseEntity.ok(alumnoService.getAllAlumnos());
    }

    // Obtener un alumno por su ID
    @GetMapping("/{id}")
    public ResponseEntity<AlumnoDTO> getAlumnoById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(alumnoService.getAlumnoById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo alumno
    @PostMapping
    public ResponseEntity<AlumnoDTO> createAlumno(@RequestBody AlumnoDTO alumnoDTO) {
        return ResponseEntity.ok(alumnoService.createAlumno(alumnoDTO));
    }

    // Actualizar un alumno existente
    @PutMapping("/{id}")
    public ResponseEntity<AlumnoDTO> updateAlumno(@PathVariable Integer id, @RequestBody AlumnoDTO alumnoDTO) {
        try {
            return ResponseEntity.ok(alumnoService.updateAlumno(id, alumnoDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un alumno por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlumno(@PathVariable Integer id) {
        try {
            alumnoService.deleteAlumno(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
