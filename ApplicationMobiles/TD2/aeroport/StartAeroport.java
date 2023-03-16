package fr.ensma.a3.ia.td02synchro.aeroport;

import fr.ensma.a3.ia.td02synchro.aeroport.processus.TourControle;

/**
 * Lancement de l'aéroport.
 *
 * @author Mikky.
 * @version Rev-2022.
 */
public class StartAeroport {

	public static void main(String[] args) {
		TourControle thTC = new TourControle();
		thTC.start();
	}
}
