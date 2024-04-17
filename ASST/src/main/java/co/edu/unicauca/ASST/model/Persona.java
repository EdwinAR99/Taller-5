package co.edu.unicauca.ASST.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Persona {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int idPersona;

   @Column
   private String tipoIdentificacion;

   @Column
   private String numeroIdentificacion;

   @Column
   private String nombres;

   @Column
   private String apellidos;

   public Persona(int idPersona) {
      this.idPersona = idPersona;
   }

}
