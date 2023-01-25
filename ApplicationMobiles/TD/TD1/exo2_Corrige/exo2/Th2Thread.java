package fr.ensma.a3.ia.amo.td1.exo2;

public class Th2Thread extends Thread {

	private TableauNoir monTabNoir;
	private Thread copainTh1;

	public Th2Thread(TableauNoir tabn, Thread th1, String nom) {
		super(nom);
		copainTh1 = th1;
		monTabNoir = tabn;
	}

	/**
	 * Corps du Thread.
	 */
	@Override
	public void run() {
		while (true) {
			int val = monTabNoir.getValeur();
			System.out.println(Thread.currentThread().getName() + " lit valeur " + val);
			val *= 10;
			System.out.println(Thread.currentThread().getName() + " calcul " + val);
			if (val > 250) {
				System.out.println("Envoie demande interruption ...");
				copainTh1.interrupt();
				return;
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
