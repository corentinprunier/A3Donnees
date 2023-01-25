package carnetcontacts.coordonnees;

import java.util.Objects;

import carnetcontacts.coordonnees.adresses.AbstractAdresse;
import carnetcontacts.coordonnees.adresses.AdresseUS;
import carnetcontacts.utils.ValParamException;

/**
 * Modélise des coordonnées
 *
 * @author Mikky
 * @version 1.0.0
 **/
public class Coordonnees {
    private String telPort;
    private String telFixe;
    private AbstractAdresse adresse;

    /**
     * Instancie des coordonnées
     *
     * @param telp tel portable (non null)
     * @param telf tel fixe (non null)
     * @throws ValParamException
     * @see {@link ValParamException}
     */
    public Coordonnees(final String telp, final String telf) throws ValParamException {
        _init(telp, telf);
    }

    /**
     * Instancie des coordonnées
     *
     * @param telp tel portable (non null)
     * @param telf tel fixe (non null)
     * @param adr  adresse (Eur ou Us)
     * @throws ValParamException
     * @see AdresseEu
     * @see AdresseUS
     */
    public Coordonnees(final String telp, final String telf, final AbstractAdresse adr) throws ValParamException {
        _init(telp, telf);
        adresse = adr;
    }

    /**
     * Obtient le tel portable
     *
     * @return String
     */
    public final String getTelPort() {
        return telPort;
    }

    /**
     * Obtient le tel fixe
     *
     * @return String
     */
    public final String getTelFixe() {
        return telFixe;
    }

    /**
     * Obtient l'adresse
     *
     * @return {@link AbstractAdresse} ou null
     */
    public final AbstractAdresse getAdresse() {
        return adresse;
    }

    /**
     * Modifie l'adresse
     *
     * @param adr
     */
    public final void setAdresse(final AbstractAdresse adr) {
        adresse = adr;
    }

    @Override
    public String toString() {
        return "Tel port : " + telPort + "\n" + "Tel fixe : " + telFixe
                + (adresse == null ? "" : "\n" + adresse.toString());
    }

    /** Redéfinition de equals */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Coordonnees))
            return false;
        Coordonnees coord = (Coordonnees) obj;
        if (adresse == null) {
            if (coord.adresse != null)
                return false;
        } else if (!adresse.equals(coord.adresse))
            return false;
        if (telFixe == null) {
            if (coord.telFixe != null)
                return false;
        } else if (!telFixe.equals(coord.telFixe))
            return false;
        if (telPort == null) {
            if (coord.telPort != null)
                return false;
        } else if (!telPort.equals(coord.telPort))
            return false;
        return true;
    }

    /** Redéfinition de hashCode */
    @Override
    public int hashCode() {
        int res = 3;
        res = prime * res + ((adresse == null) ? 0 : adresse.hashCode());
        res = prime * res + ((telFixe == null) ? 0 : telFixe.hashCode());
        res = prime * res + ((telPort == null) ? 0 : telPort.hashCode());
        return res;
    }

    private static final int prime = 11;

    private void _init(final String telp, final String telf) throws ValParamException {
        try {
            telPort = Objects.requireNonNull(telp);
            telFixe = Objects.requireNonNull(telf);
        } catch (NullPointerException ex) {
            throw new ValParamException("Coordonnees -> param(s) null");
        }
    }
}
