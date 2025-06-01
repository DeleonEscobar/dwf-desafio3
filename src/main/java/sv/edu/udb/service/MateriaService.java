package sv.edu.udb.service;

import sv.edu.udb.model.dto.MateriaDTO;

import java.util.List;

// Servicio para manejar la lógica de negocio relacionada con Materia
public interface MateriaService {
    // Obtiene una lista de todas las materias
    List<MateriaDTO> getAllMaterias();

    // Obtiene una materia por su ID
    MateriaDTO getMateriaById(Integer id);

    // Métodos para crear, actualizar y eliminar materias
    MateriaDTO createMateria(MateriaDTO materiaDTO);

    // Actualiza una materia existente
    MateriaDTO updateMateria(Integer id, MateriaDTO materiaDTO);

    // Elimina una materia por su ID
    void deleteMateria(Integer id);
}
