package carnetcontacts.contacts;

import java.util.Objects;

import carnetcontacts.coordonnees.Coordonnees;
import carnetcontacts.utils.ValParamException;

/**
 * Modélise la base d'un contact
 *
 * @author Mikky
 * @version 1.0.0
 */
public abstract class AbstractContact {
    protected String nomContact;
    protected Coordonnees coordContact;
    protected ECategorie catEntr;

    /**
     * Instancie un AbstractContact.
     *
     * @param nom   le nom (non null)
     * @param coord les coordonnées (non null)
     * @throws ValParamException
     */
    public AbstractContact(final String nom, final Coordonnees coord) throws ValParamException {
        try {
            nomContact = Objects.requireNonNull(nom, "");
        } catch (NullPointerException ex) {
            throw new ValParamException("Le nom ne peut pas être null ...");
        }
        if (coord == null) {
            throw new ValParamException("Les coordonnées ne peuvent pas être null ...");
        }
        coordContact = coord;
    }

    /**
     * Obtient le nom du contact
     *
     * @return String
     */
    public final String getNomContact() {
        return nomContact;
    }

    /**
     * Obtient les coordonnées du contact
     *
     * @return {@link Coordonnees}
     */
    public final Coordonnees getCoordContact() {
        return coordContact;
    }

    /** Redéfinition de toString */
    @Override
    public String toString() {
        return "Nom : " + nomContact;
    }

    /** Redéfinition de equals */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractContact) {
            AbstractContact cont = (AbstractContact) obj;
            if (cont.nomContact.compareTo(nomContact) == 0) {
                return true;
            }
        }
        return false;
    }

    /** Redéfinition de hashCode */
    @Override
    public int hashCode() {
        int hashc = 3;
        hashc = hashc * _HASH_ + nomContact.hashCode();
        return hashc;
    }

    private static int _HASH_ = 7;
}
