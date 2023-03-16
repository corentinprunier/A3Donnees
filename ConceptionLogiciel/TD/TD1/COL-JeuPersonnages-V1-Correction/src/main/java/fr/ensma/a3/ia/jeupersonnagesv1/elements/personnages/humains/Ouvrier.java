package fr.ensma.a3.ia.jeupersonnagesv1.elements.personnages.humains;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ensma.a3.ia.jeupersonnagesv1.elements.comportement.IAttaquableTerre;
import fr.ensma.a3.ia.jeupersonnagesv1.map.Base;
import fr.ensma.a3.ia.jeupersonnagesv1.utils.ValParamException;

/**
 * Modélise un Ouvrier
 * 
 * @author Mikky
 * @version 1.0.0
 *
 */
public class Ouvrier extends PersoHumain implements IAttaquableTerre {

    private Integer puissTravail;
    private static int numInstance;
    
    public Ouvrier (final Float nvie, final Base bse, final Integer ptrv, final String ident) throws ValParamException {
        super(nvie,bse,ident);
        _init(ptrv);
        numInstance++;
    }
    
    public Ouvrier (final Float nvie, final Base bse, final Integer ptrv) throws ValParamException {
        super(nvie,bse,("Ouvrier" + ++numInstance));
        _init(ptrv);
    }
 
    @Override
    public String toString() {
        return "Ouvrier : " + identPerso + " - Niv Vie : " + nivVie + " - P Travail : " + puissTravail;
    }

    @Override
    public void estAttaque(final Integer puissance) {
        nivVie = nivVie - puissance / 15.0f;
        logger.info(identPerso + " dit : Aiieee !! petit poltron, je n'ai même pas d'arme !!!! --> " + nivVie);
    }


    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (!(obj instanceof Ouvrier))
            return false;
        final Ouvrier ouv = (Ouvrier) obj;
        if (puissTravail == null) {
            if (ouv.puissTravail != null)
                return false;
        } else if (!puissTravail.equals(ouv.puissTravail))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = HASH * result + ((puissTravail == null) ? 0 : puissTravail.hashCode());
        return result;
    }

    private void _init(final Integer ptrv) throws ValParamException {
        if (ptrv == null) {
            throw new ValParamException();
        }
        puissTravail = ptrv;
    }

    private final Logger logger = LogManager.getLogger(Guerrier.class);
    private static final int HASH = 11;
}
