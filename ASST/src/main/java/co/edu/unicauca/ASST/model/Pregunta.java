package co.edu.unicauca.ASST.model;

import org.hibernate.mapping.List;
import java.util.List;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPregunta;
    private String nombre;
    @ManyToOne
    @JoinColumn(name="idTipoPregunta",nullable = false)
    private TipoPregunta objTipoPregunta;
    @ManyToOne
    @JoinColumn(name="idCuestionario",nullable = false)
    private Cuestionario objCuestionario;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objPregunta")
    private List<Respuesta> listaRespuesta;



}
