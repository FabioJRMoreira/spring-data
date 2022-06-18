package br.com.fabio.spring.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.fabio.spring.data.orm.Cargo;
import br.com.fabio.spring.data.repository.CargoRepository;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
	
	
	private final CargoRepository repository;
	
	public SpringDataApplication(CargoRepository cargoRepository) {
		this.repository = cargoRepository;
		
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Cargo cargo = new Cargo();
		cargo.setDescricao("DESENVOLVEDOT DE SOFTWARE");
		repository.save(cargo);
		
	}

}
