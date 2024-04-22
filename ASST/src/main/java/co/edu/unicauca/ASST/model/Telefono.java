package co.edu.unicauca.ASST.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Telefono {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int idTelefono;

   @Column(nullable = false)
   private String tipoTelefono;

   @Column(nullable = false)
   private String numero;

   @OneToOne(cascade = {CascadeType.PERSIST })
   @JoinColumn(name = "idPersona")
   private Docente objDocente;

}
