package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread {

	public int idCarro;
	private String Sentido;
	private String nomeCarro;
	private Semaphore semaforo;

	public ThreadCarro(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}

	public void run() {
		SentidoCarro();
		try {
			semaforo.acquire();
			sleep(100);
			CruzamentoCarro();
		} catch (InterruptedException e) {
			System.err.println(e);
		} finally {
			semaforo.release();
		}
	}

	private void CruzamentoCarro() {
		// Início da Seção Crítica:
		System.out.println(" O carro " + nomeCarro + " está cruzando no sentido " + Sentido + ".");
		try {
			sleep(500);
		} catch (InterruptedException e) {
			System.err.println(e);
		}
		System.out.println(" O carro " + nomeCarro + " cruzou no sentido " + Sentido + ".");
		// Fim da Seção Crítica.
	}

	private void SentidoCarro() {
		switch (idCarro) {
		case 1:
			Sentido = "Sul";
			nomeCarro = "Vermelho";
			break;
		case 2:
			Sentido = "Oeste";
			nomeCarro = "Azul";
			break;
		case 3:
			Sentido = "Norte";
			nomeCarro = "Amarelo";
			break;
		case 4:
			Sentido = "Leste";
			nomeCarro = "Verde";
			break;
		}

	}
}
