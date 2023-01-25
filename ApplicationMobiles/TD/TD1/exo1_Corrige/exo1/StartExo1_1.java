package fr.ensma.a3.ia.amo.td1.exo1;

public class StartExo1_1 {

	public static void main(String[] args) {
		TableauNoir tab = new TableauNoir();
		Th1Runnable th1ope = new Th1Runnable(tab);
		Th2Runnable th2ope = new Th2Runnable(tab);
		Thread TH1 = new Thread(th1ope, "TH1");
		Thread TH2 = new Thread(th2ope, "TH2");
		TH1.start();
		TH2.start();
	}
}
