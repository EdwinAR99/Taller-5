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

   @Column(nullable = false)
   private String tipoIdentificacion;

   @Column(unique = true, nullable = false)
   private String numeroIdentificacion;

   @Column(nullable = false)
   private String nombres;

   @Column(nullable = false)
   private String apellidos;

}
