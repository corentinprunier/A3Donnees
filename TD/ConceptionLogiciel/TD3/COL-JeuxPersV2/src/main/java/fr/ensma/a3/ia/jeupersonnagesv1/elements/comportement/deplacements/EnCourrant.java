package fr.ensma.a3.ia.jeupersonnagesv1.elements.comportement.deplacements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ensma.a3.ia.jeupersonnagesv1.elements.ElementJeu;
import fr.ensma.a3.ia.jeupersonnagesv1.elements.personnages.PersoVivant;

public class EnCourrant implements IDeplacement {

	@Override
	public void deplacer(final ElementJeu elm) {
		if (elm instanceof PersoVivant)
		logger.info(((PersoVivant)elm).getIdentPerso() + " dit : \"je me déplace 2 x plus vite en courrant !!!\"");
	}
	
	private static Logger logger = LogManager.getLogger(EnCourrant.class);
	
}
