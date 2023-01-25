package fr.ensma.a3.ia.amo.td1.exo2;

public class StartExo2 {

	public static void main(String[] args) {
		TableauNoir tab = new TableauNoir();
		Th1Thread TH1 = new Th1Thread(tab, "TH1");
		Th2Thread TH2 = new Th2Thread(tab, TH1, "TH2");
		TH1.start();
		TH2.start();
	}
}
