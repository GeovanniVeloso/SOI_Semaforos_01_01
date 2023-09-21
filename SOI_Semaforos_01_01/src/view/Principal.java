package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCarro;

public class Principal {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		
		for(int i = 1; i < 5 ; i++) {
			Thread tCarro = new ThreadCarro(i, semaforo);
			tCarro.start();
		}

	}

}
