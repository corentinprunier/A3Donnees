package fr.ensma.a3.ia.jeupersonnagesv1.elements.objets;

import fr.ensma.a3.ia.jeupersonnagesv1.map.Base;
import fr.ensma.a3.ia.jeupersonnagesv1.utils.ValParamException;

/**
 * Catapulte
 */
public class Catapulte extends Arme {

    private static int numInstance;

    public Catapulte(final Float nvie, final Base bse, final Integer ptrv) throws ValParamException {
        super(nvie, bse, ptrv, "Catapulte" + ++numInstance);
    }

    public Catapulte(final Float nvie, final Base bse, final Integer ptrv, final String idPerso) throws ValParamException {
        super(nvie, bse, ptrv, idPerso);
        numInstance++;
    }

}
