package aula20160905.testes;

public class AppTeste {
	
	public static void main(String[] args) {
		
		try {
			Integer.parseInt("Senhor!");
			//Integer.parseInt("100");
			System.out.println("Olha, é um número!!");
		} catch (NumberFormatException e) {
			System.out.println("Ixe, não é um número não... :(");
		}
		
		
	}
	

}
