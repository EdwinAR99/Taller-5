package co.edu.unicauca.ASST.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPregunta;

    @Column
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idTipoPregunta", nullable = false)
    private TipoPregunta objTipoPregunta;

    @ManyToOne
    @JoinColumn(name = "idCuestionario", nullable = false)
    private Cuestionario objCuestionario;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objPregunta")
    private List<Respuesta> listaRespuesta;

}
