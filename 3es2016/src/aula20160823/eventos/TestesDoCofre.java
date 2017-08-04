package aula20160823.eventos;

import static org.junit.Assert.*;

import javax.management.RuntimeErrorException;

import org.junit.Test;

public class TestesDoCofre {

	@Test
	public void testarSeCofreEst·FechadoPorPadr„o() {
		Cofre c = new Cofre();
		
		assertEquals(true , c.isFechado());		
	}
	@Test
	public void testarSeCofreEst·AbertoAoAbrir() {
		Cofre c = new Cofre();
		c.abrir();
		
		assertEquals(true , c.isAberto());		
	}
	@Test
	public void testarSeCofreEst·FechadoAoFechar() {
		Cofre c = new Cofre();
		c.fechar();
		
		assertEquals(true , c.isFechado());		
	}

	@Test
	public void testarSeCofreNotificouOuvidorAposAbrir() {
		Cofre c = new Cofre();
		c.setOuvidor(new OuvidorDeEventosDoCofre() {
			
			@Override
			public void cofreFoiFechado() {
			}
			
			@Override
			public void cofreFoiAberto() {
				throw new RuntimeException("Passou!");
			}
		});
		
		try {
			c.abrir();
			fail("Devia ter chamado o cofreFoiAberto!");
		} catch (RuntimeException e) {
		}		
	}
	@Test
	public void testarSeCofreNotificouOuvidorAposFechar() {
		Cofre c = new Cofre();
		c.setOuvidor(new OuvidorDeEventosDoCofre() {
			
			@Override
			public void cofreFoiFechado() {
				throw new RuntimeException("Passou!");
			}
			
			@Override
			public void cofreFoiAberto() {
			}
		});
		
		try {
			c.fechar();
			fail("Devia ter chamado o cofreFoiFechado!");
		} catch (RuntimeException e) {
		}
		
	}
	
	
	
	

}
