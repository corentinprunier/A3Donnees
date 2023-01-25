package fr.ensma.a3.ia.jeupersonnagesv1.elements;

import java.util.Objects;

import fr.ensma.a3.ia.jeupersonnagesv1.elements.comportement.deplacements.IDeplacement;
import fr.ensma.a3.ia.jeupersonnagesv1.elements.comportement.deplacements.Immobile;
import fr.ensma.a3.ia.jeupersonnagesv1.map.Base;
import fr.ensma.a3.ia.jeupersonnagesv1.utils.ValParamException;

/**
 * Modélisation d'un élément du jeu
 *
 * @author Mikky
 *
 */
public abstract class ElementJeu implements IElementJeu {

    protected Float nivVie;
    private Base laBase;
    //Ajout d'un comportement de déplacement
    protected IDeplacement compoDeplacement;

    public ElementJeu(final Float niv, final Base bse) throws ValParamException {
        try {
            nivVie = Objects.requireNonNull(niv);
            laBase = Objects.requireNonNull(bse);
            laBase.addElementJeu(this);
            compoDeplacement = new Immobile();

        } catch (final Throwable e) {
            throw new ValParamException(getClass().getSimpleName() + " : Param(s) null");
        }
    }

    public final Base getLaBase() {
        return laBase;
    }

    public final Float getNivVie() {
        return nivVie;
    }

    public void setCompoDeplacement (final IDeplacement newdep) {
    	compoDeplacement = Objects.requireNonNull(newdep);
    }
    
    @Override
    public boolean equals(final Object obj) {
        // Impossible dans une classe abstraite
        // if (this == obj)
        // return true;
        // Sera traité dans les classes concrètes avant appel Super
        // if (obj == null)
        //     return false;
        if (!(obj instanceof ElementJeu))
            return false;
        final ElementJeu elem = (ElementJeu) obj;
        // Base null impossible par construction
        // if (laBase == null) {
        // if (elem.laBase != null)
        // return false;
        // } else if (!laBase.equals(elem.laBase))
        // return false;
        if (!(laBase.equals(elem.laBase))) {
            return false;
        }
        // nivVie Null impossible par construction
        // if (nivVie == null) {
        // if (elem.nivVie != null)
        // return false;
        // } else if (!nivVie.equals(elem.nivVie))
        // return false;
        if (!(nivVie.equals(elem.nivVie))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int res = 1;
        // laBase et nivVie null impossible par construction
        // res = HASH * res + ((laBase == null) ? 0 : laBase.hashCode());
        // res = HASH * res + ((nivVie == null) ? 0 : nivVie.hashCode());
        res = HASH * res + laBase.hashCode();
        res = HASH * res + nivVie.hashCode();
        return res;
    }

    private static final int HASH = 23;

}
