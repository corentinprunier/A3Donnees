package carnetcontacts.coordonnees.adresses;

import java.util.Objects;

import carnetcontacts.utils.ValParamException;

/**
 * Classe modélisant une Adresse Européenne
 *
 * @author Mikky
 * @version 1.0.0
 */
public class AdresseEu extends AbstractAdresse {

    private String codePostal;

    /**
     * Contructeur
     *
     * @param numr  numéro de la rue (non null)
     * @param nomr  nom de la rue (non null)
     * @param nomv  nom de la ville (non null)
     * @param typad Type de l'adresse (non null)
     * @param codep code postal (non null)
     * @see ETypAdr le type de l'adresse (non null)
     * @throws ValParamException si un param null
     * @see ETypAdr
     * @see ValParamException
     */
    public AdresseEu(final Integer numr, final String nomr, final String nomv, final ETypAdr typad, final String codep)
            throws ValParamException {
        super(numr, nomr, nomv, typad);
        try {
            codePostal = Objects.requireNonNull(codep);
        } catch (NullPointerException ex) {
            throw new ValParamException("AdresseEur -> param(s) null");
        }
    }

    /**
     * Obtient le code postal
     *
     * @return String
     */
    public final String getCodePostal() {
        return codePostal;
    }

    /**
     * Redéfinition de toString
     */
    @Override
    public String toString() {
        return super.toString() + "\n" + codePostal + " " + nomVille;
    }

    /**
     * Redéfinition de equals
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        // Utilisation de getClass au lieu de instanceof
        if (getClass() != obj.getClass())
            return false;
        AdresseEu adr = (AdresseEu) obj;
        if (codePostal == null) {
            if (adr.codePostal != null)
                return false;
        } else if (!codePostal.equals(adr.codePostal))
            return false;
        return true;
    }

    /**
     * Redéfinition de hashCode
     */
    @Override
    public int hashCode() {
        int res = super.hashCode();
        res = _HASH_ * res + ((codePostal == null) ? 0 : codePostal.hashCode());
        return res;
    }

    private final static int _HASH_ = 11;
}
