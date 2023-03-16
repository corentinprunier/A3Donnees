package fr.ensma.a3.ia.jeupersonnagesv1.elements.personnages;

import fr.ensma.a3.ia.jeupersonnagesv1.elements.ElementJeu;
import fr.ensma.a3.ia.jeupersonnagesv1.elements.comportement.IDeplacable;
import fr.ensma.a3.ia.jeupersonnagesv1.map.Base;
import fr.ensma.a3.ia.jeupersonnagesv1.utils.ValParamException;

public abstract class PersoVivant extends ElementJeu implements IDeplacable {

    protected String identPerso;

    public PersoVivant(final Float nvie, final Base bse, final String ident) throws ValParamException {
        super(nvie, bse);
        if (ident == null) {
            throw new ValParamException(getClass().getSimpleName() + " : Param(s) null");
        }
        identPerso = ident;
    }

    public final String getIdentPerso() {
        return identPerso;
    }

    @Override
    public boolean equals(final Object obj) {
        // Impossible dans une classe abstraite
        // if (this == obj)
        // return true;
        if (!super.equals(obj))
            return false;
        if (!(obj instanceof PersoVivant))
            return false;
        final PersoVivant perso = (PersoVivant) obj;
        // identPerso null impossible par construction
        // if (identPerso == null) {
        // if (perso.identPerso != null)
        // return false;
        // } else if (!identPerso.equals(perso.identPerso))
        // return false;
        if (!identPerso.equals(perso.identPerso)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        // identPerso null impossible par construction
        // result = HASH * result + ((identPerso == null) ? 0 : identPerso.hashCode());
        result = HASH * result + identPerso.hashCode();
        return result;
    }

    private static final int HASH = 13;

}
