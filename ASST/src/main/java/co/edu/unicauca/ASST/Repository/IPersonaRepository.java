package co.edu.unicauca.ASST.Repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.ASST.model.Persona;

public interface IPersonaRepository extends CrudRepository<Persona, Integer> {

}
