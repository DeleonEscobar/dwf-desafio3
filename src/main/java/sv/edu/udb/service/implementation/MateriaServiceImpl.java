package sv.edu.udb.service.implementation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.model.dto.MateriaDTO;
import sv.edu.udb.model.Materia;
import sv.edu.udb.repository.MateriaRepository;
import sv.edu.udb.service.MateriaService;
import sv.edu.udb.service.mapper.MateriaMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MateriaServiceImpl implements MateriaService {
    // Inyección de dependencias
    private final MateriaRepository materiaRepository;
    private final MateriaMapper materiaMapper;

    // Constructor para la inyección de dependencias
    public MateriaServiceImpl(MateriaRepository materiaRepository, MateriaMapper materiaMapper) {
        this.materiaRepository = materiaRepository;
        this.materiaMapper = materiaMapper;
    }

    // Implementación de los métodos del servicio

    // Método para obtener todas las materias
    @Override
    public List<MateriaDTO> getAllMaterias() {
        return materiaRepository.findAll() // Obtener todas las materias de la base de datos
                .stream() // Convertir la lista a un stream
                .map(materiaMapper::toMateriaDTO) // Mapear cada entidad Materia a MateriaDTO
                .collect(Collectors.toList()); // Recoger los resultados en una lista
    }

    // Método para obtener una materia por su ID
    @Override
    public MateriaDTO getMateriaById(Integer id) {
        Materia materia = materiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada")); // Lanzar excepción si no se encuentra la materia
        return materiaMapper.toMateriaDTO(materia);
    }

    // Métodos para crear, actualizar y eliminar materias
    @Override
    public MateriaDTO createMateria(MateriaDTO materiaDTO) {
        Materia materia = materiaMapper.toMateria(materiaDTO);
        Materia saved = materiaRepository.save(materia);
        return materiaMapper.toMateriaDTO(saved); // Guardar la materia y devolver el DTO
    }

    // Método para actualizar una materia
    @Override
    public MateriaDTO updateMateria(Integer id, MateriaDTO materiaDTO) {
        Materia existing = materiaRepository.findById(id) // Buscar la materia existente por ID
                .orElseThrow(() -> new RuntimeException("Materia no encontrada")); // Lanzar excepción si no se encuentra
        existing.setNombre(materiaDTO.getNombre()); // Actualizar el nombre de la materia
        Materia updated = materiaRepository.save(existing);
        return materiaMapper.toMateriaDTO(updated);
    }

    // Método para eliminar una materia
    @Override
    public void deleteMateria(Integer id) {
        Materia existing = materiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));
        materiaRepository.delete(existing); // Eliminar la materia existente
    }
}
