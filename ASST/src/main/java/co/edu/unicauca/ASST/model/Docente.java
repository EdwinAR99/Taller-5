package co.edu.unicauca.ASST.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Docente extends Persona {

   @Column
   private String correo;

   @Column
   private String vinculacion;

   @OneToOne(mappedBy = "objDocente")
   private Telefono objTelefono;

   @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(name = "departamentoDocentes", joinColumns = @JoinColumn(name = "idPersona"), inverseJoinColumns = @JoinColumn(name = "idDepartamento"))
   private List<Departamento> listDepartamentos;

   @OneToMany(fetch = FetchType.EAGER, mappedBy = "objPersona")
   private List<Respuesta> listRespuestas;

   public  Docente() {
      this.listDepartamentos = new ArrayList<Departamento>();
      this.listRespuestas = new ArrayList<Respuesta>();
   }

   public Docente(int idPersona,
         String tipoIdentificacion,
         String numeroIdentificacion,
         String nombres,
         String apellidos,
         String correo,
         String vinculacion) {
      super(idPersona, tipoIdentificacion, numeroIdentificacion, nombres, apellidos);
      this.correo = correo;
      this.vinculacion = vinculacion;
   }

   public void addDepartamento(Departamento dpto) {
      this.listDepartamentos.add(dpto);
   }

   public void addRespuesta(Respuesta objRespuesta) {
      this.listRespuestas.add(objRespuesta);
   }
}
