package aula20160905.testes;

public class AppTeste {
	
	public static void main(String[] args) {
		
		try {
			Integer.parseInt("Senhor!");
			//Integer.parseInt("100");
			System.out.println("Olha, � um n�mero!!");
		} catch (NumberFormatException e) {
			System.out.println("Ixe, n�o � um n�mero n�o... :(");
		}
		
		
	}
	

}
