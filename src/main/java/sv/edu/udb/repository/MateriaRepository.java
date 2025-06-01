package sv.edu.udb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.udb.model.Materia;

// Repositorio para la entidad Materia que permite realizar operaciones CRUD
public interface MateriaRepository extends JpaRepository<Materia, Integer> {
}
