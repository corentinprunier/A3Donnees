package fr.ensma.a3.ia.convdevisesui.listeners;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ensma.a3.ia.convdevisesui.ConvertisseurED;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class EcouteurClavier implements EventHandler<KeyEvent> {

	private ConvertisseurED vue;

	public EcouteurClavier(final ConvertisseurED v) {
		vue = v;
	}

	@Override
	public void handle(KeyEvent event) {
		if (event.getCharacter().compareTo("A") == 0) {
			logger.info("Mise à vide des champs texte ...");
			vue.resetChampTexte();
			event.consume();
		}
	}

	private static Logger logger = LogManager.getLogger(EcouteurClavier.class);
}
