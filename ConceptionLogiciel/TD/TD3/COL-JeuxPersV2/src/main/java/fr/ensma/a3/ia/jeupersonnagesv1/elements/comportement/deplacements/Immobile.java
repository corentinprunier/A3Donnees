package fr.ensma.a3.ia.jeupersonnagesv1.elements.comportement.deplacements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ensma.a3.ia.jeupersonnagesv1.elements.ElementJeu;

public class Immobile implements IDeplacement{

	@Override
	public void deplacer(ElementJeu elm) {
		logger.warn("Cette demande est incongrue ... car je suis Immobile  !!");
	}
	
	private static Logger logger = LogManager.getLogger(Immobile.class);
	
}
