package carnetcontacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import carnetcontacts.contacts.AbstractContact;
import carnetcontacts.utils.ValParamException;

/**
 * Modélisation d'un Carnet de contacts
 *
 * @author Mikky
 * @version 1.0.0
 **/
public class CarnetContacts {

    private String nomCarnet;
    private List<AbstractContact> mesContacts;

    /**
     * Instancie un Carent de contacts
     *
     * @param nomc String (non null)
     * @param cont {@link carnetcontacts.contacts.ContactEntr} ou
     *             {@link carnetcontacts.contacts.Contact}
     * @throws ValParamException
     */
    public CarnetContacts(final String nomc, final AbstractContact cont) throws ValParamException {
        try {
            nomCarnet = Objects.requireNonNull(nomc);
            mesContacts = new ArrayList<AbstractContact>();
            Objects.requireNonNull(cont, "Le contact ne peut être null !!");
            mesContacts.add(cont);
        } catch (NullPointerException ex) {
            throw new ValParamException("Carnet --> param(s) null");
        }
    }

    /**
     * Obtient le nombre de contact(s) dans le carnet
     *
     * @return Integer
     */
    public Integer nbContacts() {
        return mesContacts.size();
    }

    /**
     * Obtient le nom du carnet
     *
     * @return String
     */
    public final String getNomCarnet() {
        return nomCarnet;
    }

    /**
     * Modifie le nom du carnet
     *
     * @param nomc String le nom
     */
    public final void setNomCarnet(final String nomc) {
        nomCarnet = nomc;
    }

    /**
     * Ajout un contact au carnet
     *
     * @param cont {@link carnetcontacts.contacts.ContactEntr} ou
     *             {@link carnetcontacts.contacts.Contact} (non null)
     * @throws ValParamException
     */
    public void Add(final AbstractContact cont) throws ValParamException {
        if (cont == null) {
            throw new ValParamException("Add -> param null");
        }
        mesContacts.add(cont);
    }

    /**
     * Supprime le contact du carnet
     *
     * @param cont {@link carnetcontacts.contacts.ContactEntr} ou
     *             {@link carnetcontacts.contacts.Contact}
     * @return True si cont supprimé, false sinon
     */
    public boolean remove(final AbstractContact cont) {
        return mesContacts.remove(cont);
    }

    /** Redéfinition de toString */
    @Override
    public String toString() {
        StringBuilder ch = new StringBuilder("Carnet : " + nomCarnet + "(" + nbContacts() + ")\n=====\n");
        for (AbstractContact iter : mesContacts) {
            ch.append(iter.toString());
            ch.append("\n-------------\n");
        }
        return ch.toString();
    }

    /**
     * Recherche un contact par son nom
     *
     * @param nom String le nom
     * @return List<AbstractContact> la liste des résultats
     */
    public List<AbstractContact> searchByName(final String nom) {
        List<AbstractContact> rech = new ArrayList<AbstractContact>();
        for (AbstractContact _cont : mesContacts) {
            if (_cont.getNomContact().compareTo(nom) == 0) {
                rech.add(_cont);
            }
        }
        return rech;
    }
}
