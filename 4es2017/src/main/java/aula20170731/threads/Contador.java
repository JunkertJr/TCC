package aula20170731.threads;

public class Contador extends Thread {
	
	
	private int inicio;
	private int fim;

	public Contador(int inicio, int fim) {
		this.inicio = inicio;
		this.fim = fim;
	}

	@Override
	public void run() {
		for (int i = this.inicio; i <= fim; i++) {
			System.out.println(this.toString() + " ==> " + i);
//			try {
//				this.sleep(10);
//			} catch (Exception e) {
//			}
		}
	}

}
