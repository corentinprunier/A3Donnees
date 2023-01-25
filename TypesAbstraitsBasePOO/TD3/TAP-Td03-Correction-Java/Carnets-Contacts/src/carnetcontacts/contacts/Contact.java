package carnetcontacts.contacts;

import java.time.LocalDate;

import carnetcontacts.coordonnees.Coordonnees;
import carnetcontacts.utils.ValParamException;

/**
 * Modelise un Contact de type personne
 *
 * @author Mikky
 * @version 1.0.0
 **/
public class Contact extends AbstractContact {
    private String prenomContact;
    private LocalDate dateNaissContact;

    /**
     * Instancie un Contact
     *
     * @param nom    String (non null)
     * @param prenom String (non null)
     * @param coord  {@link Coordonnees} (non null)
     * @throws ValParamException
     */
    public Contact(final String nom, final String prenom, final Coordonnees coord) throws ValParamException {
        super(nom, coord);
        _init(prenom);
    }

    /**
     * Instancie un Contact
     *
     * @param nom       String (non null)
     * @param prenom    String (non null)
     * @param coord     {@link Coordonnees} (non null)
     * @param datenaiss {@link LocalDate}
     * @throws ValParamException
     */
    public Contact(final String nom, final String prenom, final Coordonnees coord, final LocalDate datenaiss)
            throws ValParamException {
        super(nom, coord);
        _init(prenom);
        dateNaissContact = datenaiss;
    }

    // Attribut dérivé
    /**
     * Obtient l'âge du contact
     *
     * @return Integer (0 si pas de date de naissance)
     */
    public final Integer getAgeContact() {
        Integer age = 0;
        // calcul .. à affiner ...
        if (dateNaissContact != null) {
            LocalDate now = LocalDate.now();
            age = now.getYear() - dateNaissContact.getYear();
        }
        return age;
    }

    /**
     * Obtient le prénom du contact
     *
     * @return String
     */
    public final String getPrenomContact() {
        return prenomContact;
    }

    /**
     * Obtient la date de naissance du contact
     *
     * @return {@link LocalDate}
     */
    public final LocalDate getDateNaissContact() {
        return dateNaissContact;
    }

    /**
     * Modifie la date de naissance du contact
     *
     * @param datenaiss date de naissance
     */
    public final void setDateNaissContact(final LocalDate datenaiss) {
        dateNaissContact = datenaiss;
    }

    private void _init(final String prenom) throws ValParamException {
        if (prenom == null) {
            throw new ValParamException("Contact -> param(s) null");
        }
        prenomContact = prenom;
    }

    /** Redéfinition de toString */
    @Override
    public String toString() {
        return super.toString() + " - " + prenomContact + "\n" + coordContact.toString();
    }

    /** Redéfinition de equals */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof Contact)) {
            return false;
        }
        Contact cont = (Contact) obj;
        if (cont.prenomContact.compareTo(prenomContact) == 0) {
            if (cont.dateNaissContact.equals(dateNaissContact)) {
                return true;
            }
        }
        return false;
    }

    /** Redéfinition de hashcode */
    @Override
    public int hashCode() {
        int hashc = 7;
        hashc = hashc * _HASH_ + super.hashCode();
        hashc = hashc * _HASH_ + prenomContact.hashCode();
        hashc = hashc * _HASH_ + ((dateNaissContact == null) ? 0 : dateNaissContact.hashCode());
        return hashc;
    }

    private final static int _HASH_ = 5;
}
