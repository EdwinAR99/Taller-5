package co.edu.unicauca.ASST;

import co.edu.unicauca.ASST.model.Cuestionario;
import co.edu.unicauca.ASST.model.Pregunta;
import co.edu.unicauca.ASST.model.TipoPregunta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.ASST.Repository.ICuestionarioRepository;
import co.edu.unicauca.ASST.Repository.IDocenteRepository;

@SpringBootApplication
@Transactional
public class AsstApplication implements CommandLineRunner {

	@Autowired
	private ICuestionarioRepository cuestionarioRepository;

	@Autowired
	private IDocenteRepository docenteRepository;

	public static void main(String[] args) {
		SpringApplication.run(AsstApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Agregar cuestionario
		crearCuestionionario();
	}

	private void crearCuestionionario() {
		// Temporalmente creamos tipos de preguntas falsas
		// BORRAR DESDE AQUI
		TipoPregunta tipo1 = new TipoPregunta();
		tipo1.setNombre("Selección múltiple");
		tipo1.setDescripcion("Pregunta con opciones de respuesta múltiple");
		TipoPregunta tipo2 = new TipoPregunta();
		tipo2.setNombre("Verdadero/Falso");
		tipo2.setDescripcion("Pregunta con opciones de respuesta Verdadero o Falso");
		// BORRAR HASTA AQUI

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
		// Pregunta con tipoPregunta
		tipo1.addPregunta(pregunta1);
		tipo1.addPregunta(pregunta3);
		tipo1.addPregunta(pregunta5);

		tipo2.addPregunta(pregunta2);
		tipo2.addPregunta(pregunta4);

		pregunta1.setObjTipoPregunta(tipo1);
		pregunta2.setObjTipoPregunta(tipo2);
		pregunta3.setObjTipoPregunta(tipo1);
		pregunta4.setObjTipoPregunta(tipo2);
		pregunta5.setObjTipoPregunta(tipo1);


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

		cuestionarioRepository.save(cuestionario);
	}

	private void registrarDocente() {

	}

}


