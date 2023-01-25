package fr.ensma.a3.ia.amo.td1.exo2;

public class Th1Thread extends Thread {

	private TableauNoir monTabNoir;

	public Th1Thread(TableauNoir tabn, String nom) {
		super(nom);
		monTabNoir = tabn;
	}

	/**
	 * Corps du Thread.
	 */
	@Override
	public void run() {
		int cmpt = 1;
		boolean inter = false;
		try {
			while (cmpt < 35) {
				if (isInterrupted()) {
					System.out.println("\nPendant le travail ...");
					throw new InterruptedException();
				}
				System.out.println(Thread.currentThread().getName() + " stocke " + cmpt);
				monTabNoir.setValeur(cmpt);
				for (int i = 0; i < 100; i++) {
					System.out.printf("%d-", i);
				}
				cmpt++;
				Thread.sleep(2);
			}
		} catch (InterruptedException e) {
			System.out.println("L'interruption va avoir lieu !!!");
			inter = true;

		} finally {
			if (inter) {
				System.out.println("Attention à penser à relacher les ressources ...");
				Thread.currentThread().interrupt();
				return;
			} else {
				System.out.println("\nTerminaison normale !");
			}
		}
	}
}
