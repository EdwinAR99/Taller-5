package co.edu.unicauca.ASST.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @AllArgsConstructor
public class Cuestionario {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCuestionario;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descripcion;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "objCuestionario")
    private List<Pregunta> listPreguntas;

    public Cuestionario() {
        this.listPreguntas = new ArrayList<Pregunta>();
    }

    public void addPregunta(Pregunta pregunta){
        this.listPreguntas.add(pregunta);
    }

}
