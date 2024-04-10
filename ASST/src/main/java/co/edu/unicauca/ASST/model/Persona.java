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
   private String tipoIdentificacion;
   private String numeroIdentificacion;
   private String nombres;
   private String apellidos;

   public Persona(int idPersona){
      this.idPersona = idPersona;
   }

}
