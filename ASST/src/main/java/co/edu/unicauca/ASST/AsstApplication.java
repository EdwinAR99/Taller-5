package co.edu.unicauca.ASST;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.hibernate.dialect.function.TransactSQLStrFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.ASST.model.*;
import co.edu.unicauca.ASST.repository.*;

@SpringBootApplication
@Transactional
public class AsstApplication implements CommandLineRunner {

	@Autowired
	private ICuestionarioRepository cuestionarioRepository;

	@Autowired
	private IDepartamentoRepository departamentoRepository;

	@Autowired
	private IDocenteRepository docenteRepository;

	@Autowired
	private IPreguntaRepository preguntaRepository;

	@Autowired
	private IRespuestaRepository respuestaRepository;

	@Autowired
	private ITelefonoRepository telefonoRepository;

	@Autowired
	private ITipoPreguntaRepository tipoPreguntaRepository;

	public static void main(String[] args) {
		SpringApplication.run(AsstApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Agregar cuestionario
		crearCuestionionario();

		// Agregar docente
		registrarDocente();

		// Agregar respuestas
		registrarRepuesta();

		// Listar cuestionarios registrados
		listarCuestionarios();

		// Muestrar cuestionarios
		//mostrarCuestionario();
	}

	// Este método debe crear un cuestionario y las preguntas, y posteriormente debe
	// almacenar el cuestionario y las preguntas en la base de datos. Se parte de que los tipos de preguntas ya
	// están creados.
	private void crearCuestionionario() {

		// Crear cuestionario para almacenar preguntas
		Cuestionario cuestionario = new Cuestionario();
		cuestionario.setTitulo("Cuestionario de Prueba");
		cuestionario.setDescripcion("Este cuestionario contiene preguntas de prueba");

		// Crear preguntas para el cuestionario
		Pregunta pregunta1 = new Pregunta();
		pregunta1.setEnunciado("¿Cuál es la capital de Francia?");

		Pregunta pregunta2 = new Pregunta();
		pregunta2.setEnunciado("¿La Tierra es plana?");

		Pregunta pregunta3 = new Pregunta();
		pregunta3.setEnunciado("¿Cuál es el resultado de 2 + 2?");

		Pregunta pregunta4 = new Pregunta();
		pregunta4.setEnunciado("¿La Revolución Francesa ocurrió en el siglo XVIII?");

		Pregunta pregunta5 = new Pregunta();
		pregunta5.setEnunciado("¿Cuál es el océano más grande?");

		// Relacionar objetos

		pregunta1.setObjTipoPregunta(this.tipoPreguntaRepository.findById(1).get());
		pregunta2.setObjTipoPregunta(this.tipoPreguntaRepository.findById(2).get());
		pregunta3.setObjTipoPregunta(this.tipoPreguntaRepository.findById(1).get());
		pregunta4.setObjTipoPregunta(this.tipoPreguntaRepository.findById(2).get());
		pregunta5.setObjTipoPregunta(this.tipoPreguntaRepository.findById(1).get());

		// Cuestionario con pregunta
		pregunta1.setObjCuestionario(cuestionario);
		cuestionario.addPregunta(pregunta1);

		pregunta2.setObjCuestionario(cuestionario);
		cuestionario.addPregunta(pregunta2);

		pregunta3.setObjCuestionario(cuestionario);
		cuestionario.addPregunta(pregunta3);

		pregunta4.setObjCuestionario(cuestionario);
		cuestionario.addPregunta(pregunta4);

		pregunta5.setObjCuestionario(cuestionario);
		cuestionario.addPregunta(pregunta5);

		this.cuestionarioRepository.save(cuestionario);
	}

	// Este método permite registrar un docente y asociarlo a un departamento, y
	// posteriormente debe almacenar el docente y el departamento asociado en la base de datos. Se parte de que
	// los departamentos ya están creados.
	private void registrarDocente() {
		Docente objDocente1 = new Docente(1, "Cedula de ciudadania", "1111", "Juan David", "Beca",
				"juanbep@unicauca.edu.co", "15/04/2024");
		Docente objDocente2 = new Docente(2, "Cedula de ciudadania", "1112", "Jesus Edwin", "Adrada",
				"jesusadrada@unicauca.edu.co", "15/04/2024");
		Telefono objTelefono1 = new Telefono(1, "Celular", "321003942", objDocente1);
		Telefono objTelefono2 = new Telefono(2, "Fijo", "8445732", objDocente2);
		objDocente1.setObjTelefono(objTelefono1);
		objDocente2.setObjTelefono(objTelefono2);
		Departamento objDepartamento1 = new Departamento();
		Departamento objDepartamento2 = new Departamento();
		objDepartamento1=this.departamentoRepository.findById(1).get();
		objDepartamento2=this.departamentoRepository.findById(3).get();
		objDocente1.addDepartamento(objDepartamento1);
		objDocente2.addDepartamento(objDepartamento2);
		this.docenteRepository.save(objDocente1);
		this.docenteRepository.save(objDocente2);

	}

	// Este método debe permitir registrar las respuestas de un
	// cuestionario por un determinado docente. Considere que el docente asociado está almacenado en la base de
	// datos.
	private void registrarRepuesta(){
		Optional<Docente> docente = this.docenteRepository.findById(1);

		if (docente.isEmpty()) {
			return;
		}

		// Crear respuestas para las preguntas del primer cuestionario
		Respuesta respuesta1 = new Respuesta();
		respuesta1.setDescripcion("París");

		Respuesta respuesta2 = new Respuesta();
		respuesta2.setDescripcion("Verdadero");

		Respuesta respuesta3 = new Respuesta();
		respuesta3.setDescripcion("4");

		Respuesta respuesta4 = new Respuesta();
		respuesta4.setDescripcion("Falso");

		Respuesta respuesta5 = new Respuesta();
		respuesta5.setDescripcion("Océano Pacífico");

		// Relacionar las entidades
		respuesta1.setObjPregunta(this.preguntaRepository.findById(1).get());
		respuesta2.setObjPregunta(this.preguntaRepository.findById(2).get());
		respuesta3.setObjPregunta(this.preguntaRepository.findById(3).get());
		respuesta4.setObjPregunta(this.preguntaRepository.findById(4).get());
		respuesta5.setObjPregunta(this.preguntaRepository.findById(5).get());

		respuesta1.setObjPersona(docente.get());
		respuesta2.setObjPersona(docente.get());
		respuesta3.setObjPersona(docente.get());
		respuesta4.setObjPersona(docente.get());
		respuesta5.setObjPersona(docente.get());

		// Guardar las respuestas

		List<Respuesta> listRespuestas = new ArrayList<>();

		listRespuestas.add(respuesta1);
		listRespuestas.add(respuesta2);
		listRespuestas.add(respuesta3);
		listRespuestas.add(respuesta4);
		listRespuestas.add(respuesta5);

		this.respuestaRepository.saveAll(listRespuestas);

	}

	// Este método debe mostrar los cuestionarios, preguntas asociadas
	// y tipos de preguntas. Utilice el ligado eager para traer los tipos de preguntas y cuestionarios.
	private void listarCuestionarios(){

		Iterable<Cuestionario>listCuestionario=this.cuestionarioRepository.findAll();

		for(Cuestionario cuestionario: listCuestionario){

			System.out.println("---------------------------------------");
			System.out.println("Titulo : " + cuestionario.getTitulo());
			System.out.println("Descripcion : "+cuestionario.getDescripcion());
			Iterable<Pregunta> listPregunta=cuestionario.getListPreguntas();
			
			for(Pregunta pregunta :listPregunta){

				System.out.println("---------------------------------------");
				System.out.println("Enunciado : " +pregunta.getEnunciado());
				TipoPregunta tipoPregunta=pregunta.getObjTipoPregunta();
				System.out.println("Nombre : "+tipoPregunta.getNombre()  );
				System.out.println("Descripcion : "+tipoPregunta.getDescripcion());

			}

		}
	}

	// Este método debe mostrar las respuestas de un cuestionario que
	// fue registrado en el sistema. Por cada cuestionario se deben mostrar el docente, cuestionario, preguntas, tipos
	// de preguntas y respuestas asociadas. Utilice el ligado eager para traer los tipos de preguntas y cuestionarios.
	// Utilice el ligado lazy para traer las preguntas ligadas a una respuesta. Puede utilizar el repositorio de respuesta
	// para traer la información asociada.
	private void mostrarCuestionario(){

	}
}
