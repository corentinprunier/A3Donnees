package fr.ensma.a3.ia.td02synchro.exo1_2;

public class StartExo1_2 {

	public static void main(String[] args) {
		
		IMdd mdd = new MonMddLock();
			
		
		MonThreadEcrivain th1 = new MonThreadEcrivain(1700, 30, "TH1-Ecrire", mdd);
		MonThreadLecteur th2 = new MonThreadLecteur(300, 20, "TH2-Lire", mdd);

		th1.start();
		th2.start();

		try {
			th2.join(10000);
			th1.join(20000);
			System.out.println("===========Prog FINI============");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
