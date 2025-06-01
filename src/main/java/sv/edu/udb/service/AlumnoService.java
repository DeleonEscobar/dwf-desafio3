package sv.edu.udb.service;

import sv.edu.udb.model.dto.AlumnoDTO;
import java.util.List;

// Servicio para manejar la lógica de negocio relacionada con Alumno
public interface AlumnoService {
    // Obtiene una lista de todos los alumnos
    List<AlumnoDTO> getAllAlumnos();

    // Obtiene un alumno por su ID
    AlumnoDTO getAlumnoById(Integer id);

    // Métodos para crear, actualizar y eliminar alumnos
    AlumnoDTO createAlumno(AlumnoDTO alumnoDTO);

    // Actualiza un alumno existente
    AlumnoDTO updateAlumno(Integer id, AlumnoDTO alumnoDTO);

    // Elimina un alumno por su ID
    void deleteAlumno(Integer id);
}