package fr.ensma.a3.ia.jeupersonnagesv1.elements.personnages.animaux;

import fr.ensma.a3.ia.jeupersonnagesv1.elements.personnages.PersoVivant;
import fr.ensma.a3.ia.jeupersonnagesv1.map.Base;
import fr.ensma.a3.ia.jeupersonnagesv1.utils.ValParamException;

/**
 * Modélise un PersoAnimal
 *
 * @author Mikky
 * @version 1.0
 */
public abstract class PersoAnimal extends PersoVivant {

    /**
     * Instancie un PersoAnimal
     *
     * @param nvie  Float (non null)
     * @param bse   {@link Base} (non null)
     * @param ident String (non null)
     * @throws ValParamException
     */
    public PersoAnimal(Float nvie, Base bse, String ident) throws ValParamException {
        super(nvie, bse, ident);
    }

}
