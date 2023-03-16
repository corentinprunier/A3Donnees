package fr.ensma.a3.ia.td02synchro.exo1_2_2;

/**
 * Implémentation Mdd sans protection
 * La protection est faite par sémaphore dans les threads
 */
public class MonMdd implements IMdd{

	private String laData;
	
	public MonMdd(){
		laData="";
	}
	
	public void ercrireData(final String d){
		laData = d;
	}
	
	public String lireData(){
		try {

			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return laData;
	}
	
}
