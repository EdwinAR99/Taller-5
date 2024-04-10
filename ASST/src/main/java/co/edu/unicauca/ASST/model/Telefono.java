package co.edu.unicauca.ASST.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Telefono {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int idTelefono;
   private String tipoTelefono;
   private String numero;

   @OneToOne
   @JoinColumn(name = "idPersona")
   private Docente objDocente;

}
