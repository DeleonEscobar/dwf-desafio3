package sv.edu.udb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Indica que esta clase es una entidad JPA
@Table(name = "materia") // Nombre de la tabla en la base de datos
@Data // Genera los métodos getters y setters
@NoArgsConstructor // Genera el constructor sin parámetros
@AllArgsConstructor // Genera el constructor con todos los atributos y el constructor sin parámetros
public class Materia {
    @Id // Llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática de la llave primaria
    private Integer id;

    @Column(nullable = false) // Columna no nula
    private String nombre;
}
