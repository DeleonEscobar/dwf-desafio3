package sv.edu.udb.service.implementation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.model.dto.AlumnoDTO;
import sv.edu.udb.model.Alumno;
import sv.edu.udb.repository.AlumnoRepository;
import sv.edu.udb.service.AlumnoService;
import sv.edu.udb.service.mapper.AlumnoMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AlumnoServiceImpl implements AlumnoService {
    // Inyectamos el repositorio y el mapper
    private final AlumnoRepository alumnoRepository;
    private final AlumnoMapper alumnoMapper;

    // Constructor para la inyección de dependencias
    public AlumnoServiceImpl(AlumnoRepository alumnoRepository, AlumnoMapper alumnoMapper) {
        this.alumnoRepository = alumnoRepository;
        this.alumnoMapper = alumnoMapper;
    }

    @Override
    public List<AlumnoDTO> getAllAlumnos() {
        return alumnoRepository.findAll()
                .stream()
                .map(alumnoMapper::toAlumnoDTO)
                .collect(Collectors.toList()); // Convertir la lista de entidades Alumno a DTOs
    }

    @Override
    public AlumnoDTO getAlumnoById(Integer id) {
        Alumno alumno = alumnoRepository.findById(id) // Buscar el alumno por ID
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado")); // Lanzar excepción si no se encuentra
        return alumnoMapper.toAlumnoDTO(alumno);
    }

    @Override
    public AlumnoDTO createAlumno(AlumnoDTO alumnoDTO) {
        Alumno alumno = alumnoMapper.toAlumno(alumnoDTO); // Convertir el DTO a entidad
        Alumno saved = alumnoRepository.save(alumno); // Guardar el alumno en la base de datos
        return alumnoMapper.toAlumnoDTO(saved); // Guardar el alumno y devolver el DTO
    }

    @Override
    public AlumnoDTO updateAlumno(Integer id, AlumnoDTO alumnoDTO) {
        Alumno existing = alumnoRepository.findById(id) // Buscar el alumno existente por ID
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        existing.setNombre(alumnoDTO.getNombre());
        existing.setApellido(alumnoDTO.getApellido()); // Actualizar los campos del alumno
        // Convertir el DTO a entidad para actualizar la relación
        existing.setMateria(alumnoMapper.toAlumno(alumnoDTO).getMateria()); // Actualizar la materia
        Alumno updated = alumnoRepository.save(existing); // Guardar el alumno actualizado
        return alumnoMapper.toAlumnoDTO(updated); // Devolver el DTO actualizado
    }

    @Override
    public void deleteAlumno(Integer id) {
        Alumno existing = alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        alumnoRepository.delete(existing); // Eliminar el alumno de la base de datos
    }
}
