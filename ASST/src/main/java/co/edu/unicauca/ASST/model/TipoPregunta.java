package co.edu.unicauca.ASST.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
public class TipoPregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoPregunta;

    @Column
    private String nombre;

    @Column
    private String descripcion;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objTipoPregunta")
    private List<Pregunta> listPreguntas;

}
