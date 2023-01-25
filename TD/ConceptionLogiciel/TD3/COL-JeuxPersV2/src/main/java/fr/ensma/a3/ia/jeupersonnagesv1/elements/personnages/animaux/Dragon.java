package fr.ensma.a3.ia.jeupersonnagesv1.elements.personnages.animaux;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ensma.a3.ia.jeupersonnagesv1.elements.comportement.IAttaquable;
import fr.ensma.a3.ia.jeupersonnagesv1.elements.comportement.IAttaque;
import fr.ensma.a3.ia.jeupersonnagesv1.elements.comportement.deplacements.EnVolant;
import fr.ensma.a3.ia.jeupersonnagesv1.map.Base;
import fr.ensma.a3.ia.jeupersonnagesv1.utils.ValParamException;

/**
 * Modélise un Dragon
 * @author Mikky
 * @Version 1.0
 */
public class Dragon extends PersoAnimal implements IAttaque {

    private Integer puissAtt;
    private static int numInstance;

    /**
     * Instancie un Dragon.
     * @param nvie Float (non null)
     * @param bse {@link Base} (non null)
     * @param ident String (non null)
     * @param patt Integer (non null)
     * @throws ValParamException
     */
    public Dragon(final Float nvie, final Base bse, final String ident, final Integer patt) throws ValParamException {
        super(nvie, bse, ident);
        _init(patt);
        numInstance++;
    }

    /**
     * Instancie un Dragon.
     * @param nvie Float (non null)
     * @param bse {@link Base} (non null)
     * @param patt Integer (non null)
     * @throws ValParamException
     */
    public Dragon(final Float nvie, final Base bse, final Integer patt) throws ValParamException {
        super(nvie, bse, "Dragon" + ++numInstance);
        _init(patt);
    }

    @Override
    public String toString() {
        return "Dragon : " + identPerso + " - Niv. Vie : " + nivVie + " - P Att : " + puissAtt;
    }

    //Inutile après Ajout Strategy
/*    @Override
    public void deplacer() {
        logger.info(identPerso + " dit : je me déplace en volant");
    }
*/
    @Override
    public void aLAttaque(final IAttaquable cible) {
        logger.info(identPerso + " dit : raaahhhh !! " + cible.getIdentPerso() + " je vais te réduire en cendres !!!");
        cible.estAttaque(puissAtt);
    }

    @Override
    public void estAttaque(final Integer puissance) {
        nivVie = nivVie - puissance / 50.0f;
        logger.info(identPerso + " dit : hmmm ... qui me chatouille ... ?? --> " + nivVie);
    }

    private void _init(final Integer patt) throws ValParamException{
        if (patt == null) {
            throw new ValParamException(getClass().getName() + " : Param(s) null");
        }
        puissAtt = patt;
        compoDeplacement = new EnVolant();
    }

    private static Logger logger = LogManager.getLogger(Dragon.class);
    
}
