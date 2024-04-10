package co.edu.unicauca.ASST.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Departamento {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int idDepartamento;
   private String nombreDep;
   private String descripcion;

   @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(name = "departamentoDocentes", joinColumns = @JoinColumn(name = "idDepartamento"), inverseJoinColumns = @JoinColumn(name = "idPersona"))
   private List<Docente> listaDocentes;

}
