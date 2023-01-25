package fr.ensma.a3.ia.amo.td1.exo1;

public class Th1Thread extends Thread {

	private TableauNoirGen<Integer> monTabNoir;

	public Th1Thread(TableauNoirGen<Integer> tabn, String nom) {
		super(nom);
		monTabNoir = tabn;
	}

	/**
	 * Corps du Thread.
	 */
	@Override
	public void run() {
		int cmpt = 1;
		while (true) {
			System.out.println(Thread.currentThread().getName() + " stocke " + cmpt);
			monTabNoir.setValeur(cmpt);
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cmpt++;
		}
	}

}
