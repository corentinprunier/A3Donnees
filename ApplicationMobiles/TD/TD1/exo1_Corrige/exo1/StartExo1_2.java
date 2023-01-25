package fr.ensma.a3.ia.amo.td1.exo1;

public class StartExo1_2 {

	public static void main(String[] args) {
		TableauNoirGen<Integer> tab = new TableauNoirGen<Integer>();
		Th1Thread TH1 = new Th1Thread(tab, "TH1");
		Th2Thread TH2 = new Th2Thread(tab, "TH2");
		TH1.start();
		TH2.start();
	}
}
