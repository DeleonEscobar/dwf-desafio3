package sv.edu.udb.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sv.edu.udb.model.dto.AlumnoDTO;
import sv.edu.udb.model.Alumno;

import java.util.List;

@Mapper(componentModel = "spring", uses = { MateriaMapper.class }) // Importa el mapper de Materia
public interface AlumnoMapper {
    // Instancia del mapper para ser utilizada en el servicio
    AlumnoMapper INSTANCE = Mappers.getMapper(AlumnoMapper.class);

    // Métodos de mapeo

    // Convierte un objeto Alumno a AlumnoDTO
    AlumnoDTO toAlumnoDTO(Alumno alumno);

    // Convierte una lista de AlumnoDTO a una lista de Alumno
    List<AlumnoDTO> toAlumnoDTOList(List<Alumno> alumnoList);

    // Convierte un objeto AlumnoDTO a Alumno
    Alumno toAlumno(AlumnoDTO alumnoDTO);
}
