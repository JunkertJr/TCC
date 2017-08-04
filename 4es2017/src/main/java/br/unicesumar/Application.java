package br.unicesumar;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	private CorRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	@Transactional
	public void run(String... arg0) throws Exception {
		System.out.println("Ulha!!!!");
		System.out.println(repo);
		
		repo.save(new Cor(1L,"Amarelo"));
		repo.save(new Cor(2L,"Verde"));
		repo.save(new Cor(3L,"Azul"));
		
		listarCores();
		
		repo.delete(2L);
		
		listarCores();
		
		System.out.println("Cor id 3: " + (repo.findOne(3L)));
		
	}

	private void listarCores() {
		System.out.println("=========================");
		List<Cor> cores = repo.findAll();
		for (Cor cor : cores) {
			System.out.println(cor);
		}
	}
		
}
