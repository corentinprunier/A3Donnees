package carnetcontacts.coordonnees.adresses;

import java.util.Objects;

import carnetcontacts.utils.ValParamException;

/**
 * Modélise une Adresse US
 *
 * @author Mkky
 * @version 1.0.0
 */
public class AdresseUS extends AbstractAdresse {

    private String zipCode;
    private String stateCode;

    /**
     * Instancie une AdresseUS
     *
     * @param numr  numéro dans la rue (non null)
     * @param nomr  nom de la rue (non null)
     * @param nomv  nom de la ville (non null)
     * @param typad type de l'adresse (non null)
     * @param zcode zipcode (non null)
     * @param scode scode (non null)
     * @throws ValParamException si un des param null
     * @see ETypAdr
     * @see ValParamException
     */
    public AdresseUS(final Integer numr, final String nomr, final String nomv, final ETypAdr typad, final String zcode,
            final String scode) throws ValParamException {
        super(numr, nomr, nomv, typad);
        try {
            zipCode = Objects.requireNonNull(zcode);
            stateCode = Objects.requireNonNull(scode);
        } catch (NullPointerException ex) {
            throw new ValParamException("AdresseUS -> param(s) null !");
        }
    }

    /**
     * Obtient le zipCode
     *
     * @return String
     */
    public final String getZipCode() {
        return zipCode;
    }

    /**
     * Obtient le stateCode
     *
     * @return String
     */
    public final String getStateCode() {
        return stateCode;
    }

    /** Redéfinition de toString */
    @Override
    public String toString() {
        return super.toString() + "\n" + zipCode + " " + nomVille + "\n" + stateCode;
    }

    /** Redéfinition de equals */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (!(obj instanceof AdresseUS))
            return false;
        AdresseUS adr = (AdresseUS) obj;
        if (stateCode == null) {
            if (adr.stateCode != null)
                return false;
        } else if (!stateCode.equals(adr.stateCode))
            return false;
        if (zipCode == null) {
            if (adr.zipCode != null)
                return false;
        } else if (!zipCode.equals(adr.zipCode))
            return false;
        return true;
    }

    /** Redéfinition de hashCode */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = _HASH_ * result + ((stateCode == null) ? 0 : stateCode.hashCode());
        result = _HASH_ * result + ((zipCode == null) ? 0 : zipCode.hashCode());
        return result;
    }

    private static final int _HASH_ = 31;
}
