package fr.ensma.a3.ia.jeupersonnagesv1.elements.personnages.humains;

import fr.ensma.a3.ia.jeupersonnagesv1.elements.comportement.IAttaquable;
import fr.ensma.a3.ia.jeupersonnagesv1.elements.comportement.deplacements.EnMarchant;
import fr.ensma.a3.ia.jeupersonnagesv1.elements.personnages.PersoVivant;
import fr.ensma.a3.ia.jeupersonnagesv1.map.Base;
import fr.ensma.a3.ia.jeupersonnagesv1.utils.ValParamException;

public abstract class PersoHumain extends PersoVivant implements IAttaquable {

    public PersoHumain(final Float nvie, final Base bse, final String ident) throws ValParamException {
        super(nvie, bse, ident);
        compoDeplacement = new EnMarchant();
    }

    // Deplacement de la méthode suite à l'ajout du strategy
/*    @Override
    public void deplacer() {
        logger.info(identPerso + " dit : \"je me déplace en marchant\"");
    }
    private static Logger logger = LogManager.getLogger(PersoHumain.class);
    */
}
