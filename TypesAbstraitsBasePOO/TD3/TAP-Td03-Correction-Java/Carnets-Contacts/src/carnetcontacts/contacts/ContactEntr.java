package carnetcontacts.contacts;

import carnetcontacts.coordonnees.Coordonnees;
import carnetcontacts.utils.ValParamException;

/**
 * Modélise un Contact de type Entreprise
 *
 * @author Mikky
 * @version 1.0.0
 **/
public class ContactEntr extends AbstractContact {

    private Integer numSiret;

    /**
     * Instancie un contact entreprise
     *
     * @param nom   String (non null)
     * @param coord {@link Coordonnees} (non null)
     * @throws ValParamException
     */
    public ContactEntr(final String nom, final Coordonnees coord) throws ValParamException {
        super(nom, coord);
        numSiret = null;
        catEntr = null;
    }

    /**
     * Instancie un contact entreprise
     *
     * @param nom   String (non null)
     * @param coord {@link Coordonnees} (non null)
     * @param cat   {@link ECategorie}
     * @throws ValParamException
     */
    public ContactEntr(final String nom, final Coordonnees coord, ECategorie cat) throws ValParamException {
        super(nom, coord);
        catEntr = cat;
    }

    /**
     * Obtient la catégorie de l'entreprise
     *
     * @return {@link ECategorie}
     */
    public final ECategorie getCatEntr() {
        return catEntr;
    }

    /**
     * Modifie la catégorie de l'entreprise
     *
     * @param cat {@link ECategorie}
     */
    public final void setCatEntr(final ECategorie cat) {
        catEntr = cat;
    }

    /**
     * Obtient le numéro de siret
     *
     * @return Integer
     */
    public final Integer getNumSiret() {
        return numSiret;
    }

    /**
     * Modifie le numéro de Siret
     *
     * @param num
     */
    public final void setNumsiret(final Integer num) {
        numSiret = num;
    }

    /** Redéfinition de toString */
    @Override
    public String toString() {
        return super.toString() + (numSiret == null ? "" : " (Num siret : " + numSiret+")") + "\n" + "Catégorie : "
                + (catEntr == null ? "??" : catEntr) + "\n" + coordContact.toString();
    }

    /** Redéfinition de Equals */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (!(obj instanceof ContactEntr))
            return false;
        ContactEntr cont = (ContactEntr) obj;
        if (numSiret == null) {
            if (cont.numSiret != null)
                return false;
        } else if (!numSiret.equals(cont.numSiret))
            return false;
        if (catEntr == null) {
            if (cont.catEntr != null) {
                return false;
            }
        } else if (!catEntr.equals(cont.catEntr)) {
            return false;
        }
        return true;
    }

    /** Redéfinition hashCode */
    @Override
    public int hashCode() {
        int res = super.hashCode();
        res = _HASH_ * res + ((numSiret == null) ? 0 : numSiret.hashCode());
        res = _HASH_ * res + ((catEntr == null) ? 0 : catEntr.hashCode());
        return res;
    }

    private static final int _HASH_ = 31;
}
