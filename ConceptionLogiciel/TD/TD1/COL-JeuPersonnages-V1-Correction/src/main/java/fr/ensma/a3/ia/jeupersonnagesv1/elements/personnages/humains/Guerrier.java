package fr.ensma.a3.ia.jeupersonnagesv1.elements.personnages.humains;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ensma.a3.ia.jeupersonnagesv1.elements.comportement.IAttaquableTerre;
import fr.ensma.a3.ia.jeupersonnagesv1.elements.comportement.IAttaqueTerre;
import fr.ensma.a3.ia.jeupersonnagesv1.map.Base;
import fr.ensma.a3.ia.jeupersonnagesv1.utils.ValParamException;

/**
 * Modélise un Guerrier
 *
 * @author Mikky
 * @version 1.0
 **/
public class Guerrier extends PersoHumain implements IAttaqueTerre {

    private Integer puissAtt;
    private static int numInstance;

    /**
     * Instancie un Guerrier
     *
     * @param nvie  Float (non null)
     * @param bse   {@link Base} (non null)
     * @param patt  Integer (non null)
     * @param ident String (non null)
     * @throws ValParamException
     */
    public Guerrier(final Float nvie, final Base bse, final Integer patt, final String ident) throws ValParamException {
        super(nvie, bse, ident);
        _init(patt);
        numInstance++;
    }

    /**
     * Instancie un Guerrier
     *
     * @param nvie Float (non null)
     * @param bse  {@link Base} (non null)
     * @param patt Integer (non null)
     * @throws ValParamException
     */
    public Guerrier(final Float nvie, final Base bse, final Integer patt) throws ValParamException {
        super(nvie, bse, "Guerrier" + ++numInstance);
        _init(patt);
    }

    /**
     * Obtient la puissance d'attaque
     *
     * @return Integer
     */
    public final Integer getPuissAttaque() {
        return puissAtt;
    }

    /** Redéfinition de toString */
    @Override
    public String toString() {
        return "Guerrier : " + identPerso + " - Niv. Vie : " + nivVie + " - P Att : " + puissAtt;
    }

    @Override
    public void aLAttaque(IAttaquableTerre cible) {
        logger.info(identPerso + " dit : Ah, Ah !! " + cible.getIdentPerso() + " je vais te pourfendre !!!");
        cible.estAttaque(puissAtt);
    }

    @Override
    public void estAttaque(Integer puissance) {
        nivVie = nivVie - puissance / 20.0f;
        logger.info(identPerso + " dit : Aiieee !! ça fait mal quand même !! --> " + nivVie);
    }

    private void _init(final Integer patt) throws ValParamException {
        if (patt == null) {
            throw new ValParamException();
        }
        puissAtt = patt;
    }

    private static Logger logger = LogManager.getLogger(Guerrier.class);
}
