package aula20170417.herança;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {
	@Autowired
	private PessoaRepository repo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		repo.deleteAll();
		
		Fisica josé = new Fisica();
		josé.setNome("José Antônio de Albuquerque");
		josé.setCpf("554.545.666-11");		
		repo.save(josé);
		
		Juridica uniCesumar = new Juridica();
		uniCesumar.setNome("Centro de Ensino Superior de Maringá Ltda.");
		uniCesumar.setCnpj("79.265.617/0001-99");
		
		uniCesumar.adicionarSocio(josé, new BigDecimal("100.00"));
		
		repo.save(uniCesumar); 
		
		
	}

}
