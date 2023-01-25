package fr.ensma.a3.ia.amo.td1.exo1;

public class Th2Thread extends Thread {

	private TableauNoirGen<Integer> monTabNoir;

	public Th2Thread(TableauNoirGen<Integer> tabn, String nom) {
		super(nom);
		monTabNoir = tabn;
	}

	/**
	 * Corps du Thread.
	 */
	@Override
	public void run() {
		while (true) {
			System.out.println(Thread.currentThread().getName() + " lit valeur " + monTabNoir.getValeur());
			System.out.println(Thread.currentThread().getName() + " calcul " + monTabNoir.getValeur() * 10);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
