package co.edu.unicauca.ASST.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
public class Cuestionario {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCuestionario;

    @Column
    private String titulo;

    @Column
    private String descripcion;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Pregunta> listPreguntas;

}
