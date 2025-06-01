package sv.edu.udb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.model.dto.MateriaDTO;
import sv.edu.udb.service.MateriaService;

import java.util.List;

@RestController
@RequestMapping("/api/materias")
public class MateriaController {
    // Inyectar el servicio de Materia
    private final MateriaService materiaService;

    // Constructor para inyectar el servicio
    public MateriaController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    // Métodos para manejar las solicitudes HTTP

    // Obtener todas las materias
    @GetMapping
    public ResponseEntity<List<MateriaDTO>> getAllMaterias() {
        return ResponseEntity.ok(materiaService.getAllMaterias());
    }

    // Obtener una materia por su ID
    @GetMapping("/{id}")
    public ResponseEntity<MateriaDTO> getMateriaById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(materiaService.getMateriaById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear una nueva materia
    @PostMapping
    public ResponseEntity<MateriaDTO> createMateria(@RequestBody MateriaDTO materiaDTO) {
        return ResponseEntity.ok(materiaService.createMateria(materiaDTO));
    }

    // Actualizar una materia existente
    @PutMapping("/{id}")
    public ResponseEntity<MateriaDTO> updateMateria(@PathVariable Integer id, @RequestBody MateriaDTO materiaDTO) {
        try {
            return ResponseEntity.ok(materiaService.updateMateria(id, materiaDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una materia por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMateria(@PathVariable Integer id) {
        try {
            materiaService.deleteMateria(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
