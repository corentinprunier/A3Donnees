package fr.ensma.a3.ia.jeupersonnagesv1.elements.comportement.deplacements;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ensma.a3.ia.jeupersonnagesv1.elements.ElementJeu;
import fr.ensma.a3.ia.jeupersonnagesv1.elements.personnages.PersoVivant;

/**
 * Définition du comportement : Marcher
 * @author richardm
 *
 */
public class EnMarchant implements IDeplacement {

	@Override
	public void deplacer(final ElementJeu elm) {
		if (elm instanceof PersoVivant)
		logger.info(((PersoVivant)elm).getIdentPerso() + " dit : \"je me déplace en marchant\"");
	}
	
	private static Logger logger = LogManager.getLogger(EnMarchant.class);
}
