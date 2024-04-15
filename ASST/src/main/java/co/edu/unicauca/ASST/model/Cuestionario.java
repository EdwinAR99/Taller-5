package co.edu.unicauca.ASST.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Cuestionario {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCuestionario;
    private String titulo;
    private String descripcion;

    


}
