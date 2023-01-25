package carnetcontacts.coordonnees.adresses;

import java.util.Objects;

import carnetcontacts.utils.ValParamException;

/**
 * Classe modélisant la base d'une adresse
 *
 * @author Mikky
 * @version 1.0.0
 **/
public abstract class AbstractAdresse {

    protected Integer numRue;
    protected String nomRue;
    protected String nomVille;
    protected ETypAdr typAdr;

    /**
     * Constructeur
     *
     * @param numr  le numéro de la rue
     * @param nomr  le nom de la rue
     * @param nomv  le nom de la ville
     * @param typad le type d'adresse
     * @see ETypAdr
     */
    public AbstractAdresse(final Integer numr, final String nomr, final String nomv, final ETypAdr typad)
            throws ValParamException {
        try {
            numRue = Objects.requireNonNull(numr);
            nomRue = Objects.requireNonNull(nomr);
            nomVille = Objects.requireNonNull(nomv);
            typAdr = Objects.requireNonNull(typad);
        } catch (NullPointerException ex) {
            throw new ValParamException("Adresse : param(s) null !");
        }
    }

    /**
     * Obtient le numéro de la rue
     *
     * @return Integer
     */
    public final Integer getNumRue() {
        return numRue;
    }

    /**
     * Obtient le nom de la rue
     *
     * @return String
     */
    public final String getNomRue() {
        return nomRue;
    }

    /**
     * Obtient le nom de la ville
     *
     * @return String
     */
    public final String getNomVille() {
        return nomVille;
    }

    /**
     * Redéfinition de toString
     */
    @Override
    public String toString() {
        return "Type :" + typAdr + "\n" + numRue + " " + nomRue;
    }

    /**
     * Redéfinition equals
     **/
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof AbstractAdresse))
            return false;
        AbstractAdresse adr = (AbstractAdresse) obj;
        if (nomRue == null) {
            if (adr.nomRue != null)
                return false;
        } else if (!nomRue.equals(adr.nomRue))
            return false;
        if (nomVille == null) {
            if (adr.nomVille != null)
                return false;
        } else if (!nomVille.equals(adr.nomVille))
            return false;
        if (numRue == null) {
            if (adr.numRue != null)
                return false;
        } else if (!numRue.equals(adr.numRue))
            return false;
        if (typAdr != adr.typAdr)
            return false;
        return true;
    }

    /**
     * Redéfinition hashCode
     **/
    @Override
    public int hashCode() {
        int result = 1;
        result = _HASH_ * result + ((nomRue == null) ? 0 : nomRue.hashCode());
        result = _HASH_ * result + ((nomVille == null) ? 0 : nomVille.hashCode());
        result = _HASH_ * result + ((numRue == null) ? 0 : numRue.hashCode());
        result = _HASH_ * result + ((typAdr == null) ? 0 : typAdr.hashCode());
        return result;
    }

    private final static int _HASH_ = 31;
}
