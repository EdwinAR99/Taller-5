package co.edu.unicauca.ASST;

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

	}

	private void crearCuestionionario() {

	}

	private void registrarDocente() {

	}

}


