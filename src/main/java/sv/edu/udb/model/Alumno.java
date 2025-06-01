package sv.edu.udb.model;

import jakarta.persistence.*;
import lombok.*;

@Entity // Indica que esta clase es una entidad JPA
@Table(name = "alumno") // Nombre de la tabla en la base de datos
@Data // Genera los métodos getters y setters
@NoArgsConstructor // Genera el constructor sin parámetros
@AllArgsConstructor // Genera el constructor con todos los atributos y el constructor sin parámetros
public class Alumno {
    @Id // Llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática de la llave primaria
    private Integer id;

    @Column(nullable = false) // Columna no nula
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    // Relación N...M hacia la otra entidad
    @ManyToOne
    @JoinColumn(name = "id_materia") // Llave foránea hacia la tabla Materia
    private Materia materia;
}
