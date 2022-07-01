package br.com.fabio.spring.data.service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabio.spring.data.orm.Cargo;
import br.com.fabio.spring.data.repository.CargoRepository;
@Service
public class CargoService {
	private Boolean system = true;
	@Autowired
	private CargoRepository repository;
	
	public void iniciar(Scanner scanner) {
		
		while(system) {
			System.out.println("Qual a funcao do cargo voce quer executar ?");
			System.out.println("0-Sair");
			System.out.println("1-Salvar");
			System.out.println("2-Atualizar");
			System.out.println("3-Visualizar");
			System.out.println("4-Visualizar por ID");
			System.out.println("5-Apagar por ID");
			int selecao = scanner.nextInt();
			switch (selecao) {
			case 1:
				salvar(scanner);
				break;
			case 2:
				atualizar(scanner);
				break;
			case 3:
				visualizar();
				break;
			case 4:
				buscaId(scanner);
				break;
			case 5:
				apagar(scanner);
				break;
			default:
				system = false;
				break;
			}
		}
		
	}
	
	private void salvar(Scanner scanner) {
		System.out.println("Descricao do cargo");
		String descricao = scanner.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		repository.save(cargo);
		System.out.println("Salvo");
	}
	
	private void atualizar(Scanner scanner) {
		System.out.println("Informe o ID do cargo a ser atualizado");
		int id  = scanner.nextInt();
		System.out.println("Entre com a nova descricao");
		String descricao = scanner.next();
		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricao(descricao);
		repository.save(cargo);
		System.out.println("Salvo");
		
	}
	
	private void visualizar() {
		List <Cargo> cargos = (List<Cargo>) repository.findAll();
		cargos.forEach(cargo->System.out.println(cargo.getId()+" "+cargo.getDescricao()));
	}
	
	private void buscaId(Scanner scanner) {
		
		System.out.println("Informe o ID do cargo a ser buscado");
		long id  = scanner.nextInt();
		Optional<Cargo> cargo = repository.findById(id);
		if(cargo.isPresent())
		{
			System.out.println(cargo.get().getDescricao());
		}else {
			System.out.println("Id nao cadastrado");
		}
		
	}
	
	private void apagar(Scanner scanner) {
		System.out.println("Informe o ID do cargo a ser buscado");
		try {
			long id  = scanner.nextInt();
			repository.deleteById(id);
			System.out.println("Registro apagado");
		} catch (Exception e) {
			System.out.println("Erro ao deletar id nao encontrado");
		}
		
		
	}
}
