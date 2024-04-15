package co.edu.unicauca.ASST.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRespuesta;

    @ManyToOne
    @JoinColumn(name = "idPersona", nullable = false)
    private Persona objPersona;

    @ManyToOne
    @JoinColumn(name = "idPregunta", nullable = false)
    private Pregunta objPregunta;

}
