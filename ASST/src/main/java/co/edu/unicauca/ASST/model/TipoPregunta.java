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
public class TipoPregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoPregunta;

    @Column
    private String nombre;

    @Column
    private String descripcion;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE} , mappedBy = "objTipoPregunta")
    private List<Pregunta> listPreguntas;

    public TipoPregunta() {
        this.listPreguntas = new ArrayList<Pregunta>();
    }

    public void addPregunta(Pregunta pregunta){
        this.listPreguntas.add(pregunta);
    }

}
