package fr.ensma.a3.ia.jeupersonnagesv1.elements.objets;

import fr.ensma.a3.ia.jeupersonnagesv1.elements.ElementJeu;
import fr.ensma.a3.ia.jeupersonnagesv1.map.Base;
import fr.ensma.a3.ia.jeupersonnagesv1.utils.ValParamException;

/**
 * Modélise la base d'une Arme
 */
public abstract class Arme extends ElementJeu {

    protected Integer puissAttaque;
    protected String identArme;

    public Arme(final Float nvie, final Base bse, final Integer patt, final String idarme) throws ValParamException {
        super(nvie, bse);
        if ((patt == null) || (idarme == null)){
            throw new ValParamException(getClass().getSimpleName() + " : Param(s) null");
        } else {
            puissAttaque = patt;
            identArme = idarme;
        }
    }

    public final Integer getPuissAttaque() {
        return puissAttaque;
    }


    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Arme arm = (Arme) obj;
        if (!puissAttaque.equals(arm.puissAttaque)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = HASH * result + puissAttaque.hashCode();
        return result;
    }

    private static final int HASH = 31;

}
