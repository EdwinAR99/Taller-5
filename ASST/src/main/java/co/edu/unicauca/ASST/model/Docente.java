package co.edu.unicauca.ASST.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
public class Docente extends Persona{

   private String correo;
   private String vinculacion;

   @OneToOne(mappedBy = "objDocente")
   private Telefono objTelefono;

   @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(name = "departamentoDocentes", joinColumns = @JoinColumn(name = "idPersona"), inverseJoinColumns = @JoinColumn(name = "idDepartamento"))
   private List<Departamento> listDepartamentos;

   public Docente(int idPersona,
                  String tipoIdentificacion,
                  String numeroIdentificacion,
                  String nombres,
                  String apellidos,
                  String correo,
                  String vinculacion){
      super(idPersona, tipoIdentificacion, numeroIdentificacion, nombres, apellidos);
      this.correo = correo;
      this.vinculacion = vinculacion;
   }

}
