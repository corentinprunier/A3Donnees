package fr.ensma.a3.ia.jeupersonnagesv1.elements;

import java.util.Objects;

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

    public ElementJeu(final Float niv, final Base bse) throws ValParamException {
        try {
            nivVie = Objects.requireNonNull(niv);
            laBase = Objects.requireNonNull(bse);
            laBase.addElementJeu(this);

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

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof ElementJeu))
            return false;
        final ElementJeu elem = (ElementJeu) obj;
        if (laBase == null) {
            if (elem.laBase != null)
                return false;
        } else if (!laBase.equals(elem.laBase))
            return false;
        if (nivVie == null) {
            if (elem.nivVie != null)
                return false;
        } else if (!nivVie.equals(elem.nivVie))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int res = 1;
        res = HASH * res + ((laBase == null) ? 0 : laBase.hashCode());
        res = HASH * res + ((nivVie == null) ? 0 : nivVie.hashCode());
        return res;
    }

    private static final int HASH = 23;

}
