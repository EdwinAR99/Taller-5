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
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPregunta;

    @Column
    private String enunciado;

    @ManyToOne
    @JoinColumn(name = "idTipoPregunta", nullable = false)
    private TipoPregunta objTipoPregunta;

    @ManyToOne
    @JoinColumn(name = "idCuestionario", nullable = false)
    private Cuestionario objCuestionario;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objPregunta")
    private List<Respuesta> listaRespuestas;

    public Pregunta() {
        this.listaRespuestas = new ArrayList<Respuesta>();
    }

    public void addRespuesta(Respuesta respuesta){
        this.listaRespuestas.add(respuesta);
    }

}
