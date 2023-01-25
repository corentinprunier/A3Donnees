package fr.ensma.a3.ia.amo.td1.exo1;

public class Th1Runnable implements Runnable {

	private TableauNoir monTabNoir;

	public Th1Runnable(TableauNoir tabn) {
		monTabNoir = tabn;
	}

	/**
	 * Redéfinition du corps du Thread. Issu de l'interface Runnable.
	 *
	 * @see Runnable
	 */
	@Override
	public void run() {
		int cmpt = 1;
		while (true) {
			System.out.println(Thread.currentThread().getName() + " stocke " + cmpt);
			monTabNoir.setValeur(cmpt);
			try {
				Thread.sleep(350);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cmpt++;
		}
	}

}
