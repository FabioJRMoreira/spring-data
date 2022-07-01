package br.com.fabio.spring.data;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.fabio.spring.data.service.CargoService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
	@Autowired
    private CargoService service;
	private Boolean system = true;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// para nao tem que criar uma api ou aplicacao web
		// USUARIO ENTRA PELA CONSOLE
		Scanner scanner = new Scanner(System.in);
		while (system) {
			System.out.println("Qual Acao voce quer executar ?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			int action = scanner.nextInt();
			if (action ==1) {
				service.iniciar(scanner);
			}else {
				system = false;
			}
		}

	}

}
