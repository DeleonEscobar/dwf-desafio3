package sv.edu.udb.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sv.edu.udb.model.dto.MateriaDTO;
import sv.edu.udb.model.Materia;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MateriaMapper {
    // Instancia del mapper para ser utilizada en el servicio
    MateriaMapper INSTANCE = Mappers.getMapper(MateriaMapper.class);

    // Métodos de mapeo

    // Convierte un objeto Materia a MateriaDTO
    MateriaDTO toMateriaDTO(Materia materia);

    // Convierte una lista de MateriaDTO a una lista de Materia
    List<MateriaDTO> toMateriaDTOList(List<Materia> materiaList);

    // Convierte un objeto MateriaDTO a Materia
    Materia toMateria(MateriaDTO materiaDTO);
}
