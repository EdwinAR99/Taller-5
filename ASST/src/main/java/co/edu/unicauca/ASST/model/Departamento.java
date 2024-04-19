package co.edu.unicauca.ASST.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @AllArgsConstructor
public class Departamento {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int idDepartamento;

   @Column
   private String nombreDep;

   @Column
   private String descripcion;

   @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST})
   @JoinTable(name = "departamentoDocentes", joinColumns = @JoinColumn(name = "idDepartamento"), inverseJoinColumns = @JoinColumn(name = "idPersona"))
   private List<Docente> listaDocentes;

   public Departamento() {
      this.listaDocentes = new ArrayList<Docente>();
   }

}
